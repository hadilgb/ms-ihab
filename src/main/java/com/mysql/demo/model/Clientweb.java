package com.mysql.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "client_web")
public class Clientweb {



        private long id;
        private String nom;
        private String prenom;
        private long tel;
         private String login;
         private String mdp;
        private String adresse;

        public Clientweb() {

        }

        public Clientweb(long id,String nom,String prenom,long tel,String login,String mdp,String adresse) {
            this.nom = nom;
            this.prenom = prenom;
            this.tel = tel;
            this.login = login;
            this.mdp = mdp;
            this.adresse = adresse;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        @Column(name = "nom", nullable = false)
        public String getNom() {
            return nom;
        }
        public void setnom(String nom) {
            this.nom = nom;
        }

        @Column(name = "prenom", nullable = false)
        public String getprenom() {
            return prenom;
        }
        public void setprenom(String lastName) {
            this.prenom = prenom;
        }

        @Column(name = "tel", nullable = false)
        public Long gettel() {
            return tel;
        }
        public void settel(Long tel) {
            this.tel = tel;
        }
    @Column(name = "login", nullable = false)
    public String getlogin() {
        return login;
    }
    public void setlogin(String login) {
        this.login = login;
    }
    @Column(name = "mdp", nullable = false)
    public String getmdp() {
        return mdp;
    }
    public void setmdp(String mdp) {
        this.mdp = mdp;
    }
    @Column(name = "adresse", nullable = false)
    public String getadresse() {
        return adresse;
    }
    public void setadresse(String adresse) {
        this.adresse = adresse;
    }

        @Override
        public String toString() {
            return "Clientweb [id=" + id + ", nom=" + nom + ", prénom=" + prenom + ", tél=" + tel
                    + "]";
        }


}
