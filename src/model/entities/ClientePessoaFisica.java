package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ClientePessoaFisica extends Cliente {

	private String cpfCliente;
	private Date dataNasc;
	private static final String Formato = "###.###.###-##";

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	public ClientePessoaFisica() {
		super();
	}

	public ClientePessoaFisica(Integer idCliente, String cpfCliente, String dataNasc, String nomeCliente,
			String foneCliente1, String foneCliente2,
		String emailCliente, Endereco enderecoCliente) {
	super(idCliente, nomeCliente, foneCliente1, foneCliente2, emailCliente, enderecoCliente);
	this.cpfCliente = cpfCliente;
	try {
		this.dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	public ClientePessoaFisica(String nomeCliente, String cpfCliente, String dataNasc, String foneCliente1, String foneCliente2, String emailCliente,
			Endereco enderecoCliente) {
		super(nomeCliente, foneCliente1, foneCliente2, emailCliente, enderecoCliente);
		this.cpfCliente = cpfCliente;
		try {
			this.dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\	
	public boolean isCPF(){
        
        if (this.cpfCliente.equals("00000000000") || 
            this.cpfCliente.equals("11111111111") || 
            this.cpfCliente.equals("22222222222") || 
            this.cpfCliente.equals("33333333333") ||
            this.cpfCliente.equals("44444444444") ||
            this.cpfCliente.equals("55555555555") ||
            this.cpfCliente.equals("66666666666") ||
            this.cpfCliente.equals("77777777777") ||
            this.cpfCliente.equals("88888888888") ||
            this.cpfCliente.equals("99999999999") ||
            this.cpfCliente.length() != 11)
            return(false);
        
        char dig10, dig11; 
        int sm, i, r, num, peso; 

        try { 
            // Calculo do primeiro Digito Verificador 
            sm = 0; 
            peso = 10; 
            for (i=0; i<9; i++) { 
                num = (int)(this.cpfCliente.charAt(i) - 48); 
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig10 = '0'; 
            else 
                dig10 = (char)(r + 48); 

            // Calculo do segundo Digito Verificador 
            sm = 0; 
            peso = 11; 
            for(i=0; i<10; i++) { 
                num = (int)(this.cpfCliente.charAt(i) - 48);
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig11 = '0'; 
            else 
                dig11 = (char)(r + 48); 

            if ((dig10 == this.cpfCliente.charAt(9)) && (dig11 == this.cpfCliente.charAt(10))) 
                return(true); 
            else return(false);
        } catch(Exception e) { 
            return(false); 
        } 
    }


    private String Format(String C, boolean Mascara){
        if(Mascara){
            return(C.substring(0, 3) + "." + C.substring(3, 6) + "." +
            C.substring(6, 9) + "-" + C.substring(9, 11));
        }else{
            C = C.replace(".","");
            C = C.replace("-","");
            return C;
        }
    }
    
    
    public static DefaultFormatterFactory getFormat(){
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }
    }
    
///////////////////////////////////////////////////////////////////

	public void setCpfCliente(String cpfCliente) {
//		if(cpfCliente.length() == 11){
//		      //valido = false;
//			if (cpfCliente.substring(0,11).matches("[0-9]*")) {
		this.cpfCliente = cpfCliente;
//			}
//		}
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
//    public String getCpfCliente(boolean Mascara) {
//        return Format(this.cpfCliente,Mascara);
//    }

	public Date getDataNasc() {
		return dataNasc;
	}
	
	public String getDataNascFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataNasc);
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "ClientePessoaFisica ["
				+ "getIdCliente()=" + getIdCliente() 
				+ ", getNomeCliente()=" + getNomeCliente()
				+ ", cpfCliente=" + cpfCliente 
				+ ", dataNasc=" + dataNasc 
				+ ", getFoneCliente1()=" + getFoneCliente1()
				+ ", getFoneCliente2()=" + getFoneCliente2() 
				+ ", getEmailCliente()=" + getEmailCliente() 
				+ ", getEnderecoCliente()=" + getEnderecoCliente()
				+ "]";
	}

	
}
