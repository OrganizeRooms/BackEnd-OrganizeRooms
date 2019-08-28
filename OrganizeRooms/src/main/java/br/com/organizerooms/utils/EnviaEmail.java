package br.com.organizerooms.utils;

import br.com.organizerooms.dto.EnviaEmailDTO;
import br.com.organizerooms.models.EmailEnviado;
import br.com.organizerooms.services.EmailEnviadoServiceImpl;
import br.com.organizerooms.services.UsuarioServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */
@Service
public class EnviaEmail {

    @Autowired
    private EmailEnviadoServiceImpl emailEnviadoService;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    private final String smtp = "smtp.gmail.com";
    private final Integer portaSmtp = 587;
    private final String usuarioSmtp = "projetoblucake@gmail.com";
    private final String senhaUsuarioSmtp = "blucake2019";
    private DefaultAuthenticator autenticador;
    private HtmlEmail email;

    public EnviaEmail() {
    }

    private boolean validaEnvio(EnviaEmailDTO emailDTO) {
        if (emailDTO == null) {
            return false;
        } else if (emailDTO.getTipoEnvio() == 1) {
            return !(emailDTO.getRemetEmail().trim().isEmpty() || emailDTO.getRemetNome().trim().isEmpty());
        }
        return !(emailDTO.getDestEmail().trim().isEmpty() || emailDTO.getDestNome().trim().isEmpty()
                || emailDTO.getRemetEmail().trim().isEmpty() || emailDTO.getRemetNome().trim().isEmpty());
    }

    public Boolean enviar(EnviaEmailDTO emailDTO) {
        autenticador = new DefaultAuthenticator(usuarioSmtp, senhaUsuarioSmtp);
        email = new HtmlEmail();
        if (validaEnvio(emailDTO)) {
            try {
                email.setHostName(smtp);
                email.setSmtpPort(portaSmtp);
                email.setAuthenticator(autenticador);
                email.setTLS(true);
                if (emailDTO.getTipoEnvio() == 1) {
                    emailDTO.setDestEmail(usuarioSmtp);
                    emailDTO.setAssunto("Solicitação de Cadastro de Novo Confeiteiro");
                    emailDTO.setMensagem(
                            "Novo interessado em ser Confeiteiro no BluCake!<br/><br/>"
                            + "Nome: <b>" + emailDTO.getRemetNome().trim().toUpperCase() + "</b><br/>"
                            + "Email: " + emailDTO.getRemetEmail() + "<br/><br/>"
                            + "Entrar em contato para coletar mais informações!");
                } else {
                    emailDTO.setAssunto(emailDTO.getRemetNome().trim() + " - Novo Interessado");
                    if (emailDTO.getMensagem() == null) {
                        emailDTO.setMensagem("<i>Nao foi deixado nenhuma mensagem!</i>");
                    }
                    if (emailDTO.getTelefone() == null || emailDTO.getTelefone().trim().equals("")) {
                        emailDTO.setTelefone("<i>Sem telefone de Contato!</i>");
                    }
                    String msg = "Prezado(a) <b>" + emailDTO.getDestNome().trim() + "</b>,<br/><br/> " + "<b>" + emailDTO.getRemetNome().trim().toUpperCase()
                            + "</b> está interessado em <b>" + emailDTO.getNomeReceita().trim().toUpperCase() + "</b> e lhe enviou uma mensagem.<br/><br/>"
                            + "----------- Mensagem -----------<br/>"
                            + emailDTO.getMensagem() + "<br/><br/> Telefone de Contato: " + emailDTO.getTelefone().trim() + "<br/>"
                            + "<br/>&emsp;<b><i>Enviado por BluCake</i></b>";
                    emailDTO.setMensagem(msg);
                }

                email.setFrom(emailDTO.getRemetEmail().trim());
                email.addTo(emailDTO.getDestEmail().trim());
                email.setSubject(emailDTO.getAssunto());
//                email.setMsg(emailDTO.getMensagem());
                email.setHtmlMsg(emailDTO.getMensagem());
                email.send();
            } catch (EmailException e) {
                System.err.println("EnviaEmail - Falha ao enviar email para: " + emailDTO.getDestEmail().trim()
                        + " | Erro: " + e.toString());
                gravaEnvio(false, emailDTO);
                return false;
            }
            gravaEnvio(true, emailDTO);
            return true;
        } else {
            gravaEnvio(false, emailDTO);
            return false;
        }
    }

    private void gravaEnvio(boolean enviado, EnviaEmailDTO emailDTO) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        EmailEnviado emailEnviado;

        if (emailDTO.getTipoEnvio() == 1) {
            emailEnviado = new EmailEnviado(
                    emailDTO.getDestEmail(),
                    emailDTO.getRemetEmail(),
                    emailDTO.getRemetNome(),
                    emailDTO.getTipoEnvio(),
                    emailDTO.getAssunto(),
                    emailDTO.getMensagem(),
                    enviado,
                    calendar.getTime());
        } else {
            emailEnviado = new EmailEnviado(
                    null,
                    emailDTO.getDestEmail().trim(),
                    emailDTO.getDestNome().trim(),
                    emailDTO.getRemetEmail().trim(),
                    emailDTO.getRemetNome().trim(),
                    emailDTO.getTipoEnvio(),
                    emailDTO.getTelefone().trim(),
                    emailDTO.getAssunto().trim(),
                    emailDTO.getMensagem().trim(),
                    enviado,
                    emailDTO.getIdReceita(),
                    emailDTO.getNomeReceita(),
                    emailDTO.getIdUsuario(),
                    calendar.getTime());
        }

        emailEnviadoService.gravaEmailEnviado(emailEnviado);
    }
}
