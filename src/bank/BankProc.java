package bank;

public interface BankProc {

    /**
     * Adauga o noua persoana
     * @invariant isWellFormed()
     * @pre persoana!=null
     * @pre !bank.containsKey(persoana)
     * @post bank.containsKey(persoana)
     */
    public void addPerson(Person persoana);

    /**
     * Sterge o persoana
     * @invariant isWellFormed()
     * @pre persoana!=null
     * @pre bank.contains(persoana)
     * @post size()==size()@pre-1
     * @post !bank.contains(persoana)
     */
    public void removePerson(Person persoana);

    /**
     * Editeaza o persoana
     * @invariant isWellFormed()
     * @pre persoana!=null
     * @pre bank.contains(persoana)
     * @post size()==size()@pre
     * @post bank.contains(persoana)
     */
    public void editPerson(Person persoana);

    /**
     * Adauga un cont al unei persoane
     * @invariant isWellFormed()
     * @pre cont!=null
     * @post size()==size()@pre +1
     * @param cont
     */
    public void addAcount(Account cont);


    /**
     * Adauga un cont al unei persoane
     * @invariant isWellFormed()
     * @pre cont!=null
     * @post size()==size()@pre -1
     * @param cont
     */
    public void removeAcount(Account cont);

    /**
     * Editeaza datele unui cont
     * @invariant isWellFormed()
     * @pre cont!=null
     * @param cont
     */
    public void writeAccount(Account cont) throws Exception;

}
