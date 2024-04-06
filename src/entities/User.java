package entities;

public class User {

    private Address address;
    private String name;
    private String email;
    private String companyCode;
    private String cpf;
    private String type;
    private float salary;

    public String getCompanyCode() {
        return companyCode;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void printData() {
        System.out.println("Nome: " + name);
        System.out.println("Email: " + email);
        System.out.println("Código da Empresa: " + companyCode);
        System.out.println("CPF: " + cpf);
        System.out.println("Tipo: " + type);
        System.out.println("Salário: " + salary);
        System.out.println("Endereço:");
        System.out.println("CEP: " + address.getCep());
        System.out.println("País: " + address.getCountry());
        System.out.println("Estado: " + address.getProvince());
        System.out.println("Cidade: " + address.getCity());
        System.out.println("Rua: " + address.getStreet());
        System.out.println("Número: " + address.getNumber());
    }

}