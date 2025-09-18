package entities;
import java.time.LocalDate;
public class Transaction {

        private String idTransaction;
        private String type; // Dépôt, Retrait, Virement
        private double montant;
        private LocalDate date;
        private String AccountSource;
        private String AccountDestination;


        public Transaction(String idTransaction, String type, double montant, LocalDate date, String accountSource, String accountDestination) {
            this.idTransaction = idTransaction;
            this.type = type;
            this.montant = montant;
            this.date = date;
            AccountSource = accountSource;
            AccountDestination = accountDestination;
        }

        //setters
        public void setIdTransaction(String idTransaction) {
            this.idTransaction = idTransaction;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setMontant(double montant) {
            this.montant = montant;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public void setAccountSource(String accountSource) {
            AccountSource = accountSource;
        }

        public void setAccountDestination(String accountDestination) {
            AccountDestination = accountDestination;
        }

        //getters

        public String getIdTransaction() {
            return idTransaction;
        }

        public String getType() {
            return type;
        }

        public double getMontant() {
            return montant;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getAccountSource() {
            return AccountSource;
        }

        public String getAccountDestination() {
            return AccountDestination;
        }

    }


