package entities;

public class Usuario {

    private Endereco endereco;
    private String nome;
    private String email;
    private String codigoEmpresa;
    private String cpf;
    private String tipo;
    private float salario;

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Código da Empresa: " + codigoEmpresa);
        System.out.println("CPF: " + cpf);
        System.out.println("Tipo: " + tipo);
        System.out.println("Salário: " + salario);
        System.out.println("Endereço:");
        System.out.println("CEP: " + endereco.getCep());
        System.out.println("País: " + endereco.getPais());
        System.out.println("Estado: " + endereco.getEstado());
        System.out.println("Cidade: " + endereco.getCidade());
        System.out.println("Rua: " + endereco.getRua());
        System.out.println("Número: " + endereco.getNumero());
    }

}