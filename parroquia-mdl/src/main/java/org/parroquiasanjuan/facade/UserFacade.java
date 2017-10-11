package org.parroquiasanjuan.facade;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.parroquiasanjuan.mdl.User;
import org.parroquiasanjuan.util.security.Security;

/**
 *
 * @author lveliz
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "org.parroquiasanjuan_parroquia-web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User login(User us, String password) {

        try {

            User user = (User) em.createNamedQuery("User.findByUsername")
                    .setParameter("username", us.getUsername()).getResultList().get(0);

            if (user != null) {

                byte[] salt = Security.base64Decode(user.getPasswordSalt());
                SecretKeySpec key = Security.createSecretKey(password.toCharArray(), salt, Security.ITERATION_COUNT, Security.KEY_LENGTH);
                String decripted = Security.decrypt(user.getPasswordHash(), key);

                if (!decripted.equals(password)) {
                    return null;
                }

            }

            return user;

        } catch (IOException | GeneralSecurityException e) {
            return null;
        }

    }

}
