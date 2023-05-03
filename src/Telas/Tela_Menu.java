/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;
import ModelBean.*;
import ModelDAO.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author anton
 */
public class Tela_Menu extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Menu
     */
    public Tela_Menu() {
        initComponents();
        //Desabilitando os paineis para habilitá-los só quando necessário
        painel_Funcionário.setVisible(false);
        painel_Cliente.setVisible(false);
        painel_Fornecedor.setVisible(false);
        painel_Produto.setVisible(false);
        painel_Servico.setVisible(false);
        // desabilita as labels de aviso para aparecer só quando o mouse passar por cima do campo
        label_cpf_Aviso.setVisible(false);
        label_cpf_Aviso_Cliente.setVisible(false);
        label_cnpj_Aviso.setVisible(false);
        // desabilita o frame na hora de selecionar o dono
        frame_dono.setVisible(false);
    }
    // Método de Cadastro de Servico
      public void CadastrarServico(){
    BeanServico beanserv = new BeanServico(); // cria objeto para acessar as variaveis
   
    //seta nas variaveis os valores dos campos
   beanserv.setNome_Func_Serv(campo_nome_Funcionario_Servico.getText());
   beanserv.setDescri_Serv(txt_descricao.getText());
   beanserv.setFk_cod_Ani(Integer.parseInt(campo_cod_Ani.getText()));
   beanserv.setFk_cod_Func(Integer.parseInt(campo_cod_Func_Servico.getText()));
   
   
        
    DaoServico daoServico = new DaoServico(); // cria objeto para acessar os metodos sql
    
    
    daoServico.inserirDados(beanserv); // coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    JOptionPane.showMessageDialog(null, "Cadastro realizou certim");
    }
      public void ListarFuncionarioServico(){
        try {
            DaoFuncionario daofunc = new DaoFuncionario(); // criar o objeto com o metodo de listagem
            
            List<BeanFuncionario> listadefuncionarios = daofunc.ListadeFuncionario(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelafunc = (DefaultTableModel) table_Funcionário_Servico.getModel();
            tabelafunc.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanFuncionario func : listadefuncionarios){ // cria um objeto  da classe bean que recebe os valores da lista
            tabelafunc.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
            func.getCod_Func(), // insere as informações correspondentes em cada coluna
                func.getNome_Func(),
                func.getCpf_Func(),
                func.getEndereco_Func(),
                func.getTelefone_Func()
            
            
            
            });
            
            
            }
        } catch (Exception e) {
        }
    
    }
    
    // Método de Listar clientes que serão donos na Tabela
      public void ListarClientesDonos(){
        try {
            DaoCliente daoclie = new DaoCliente(); // criar o objeto com o metodo de listagem
            
            List<BeanCliente> listadeclientes = daoclie.ListadeCliente(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelaclie = (DefaultTableModel) table_Cliente_Dono.getModel();
            tabelaclie.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanCliente clie : listadeclientes){ // cria um objeto  da classe bean que recebe os valores da lista
            tabelaclie.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
            clie.getCod_Clie(), // insere as informações correspondentes em cada coluna
                clie.getNome_Clie(),
                clie.getCpf_Clie(),
                clie.getEndereco_Clie(),
                clie.getTelefone_Clie()
            
            
            
            });
            
            
            }
        } catch (Exception e) {
        }
    
    }
    
     // Método de Listar Animais na Tabela
      public void ListarAnimal(){
        try {
            DaoAnimal daoani = new DaoAnimal(); // criar o objeto com o metodo de listagem
            
            List<BeanAnimal> listadeanimais = daoani.ListadeAnimal(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelaani = (DefaultTableModel) table_Animal.getModel();
            tabelaani.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanAnimal ani : listadeanimais){
                // cria um objeto  da classe bean que recebe os valores da lista
            tabelaani.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
          ani.getCod_Ani(),
                ani.getNome_Ani(),
                ani.getTipo_Ani(),
                ani.clie.getNome_Clie()
                
            
            
            
            });
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Animal"+e);
        }
    
    }
    
    //Método de Cadastrar o Animal
    
    public void CadastrarAnimal(){
    BeanAnimal beanani = new BeanAnimal(); // cria objeto para acessar as variaveis
   
    //seta nas variaveis os valores dos campos
   beanani.setNome_Ani(campo_nome_Animal.getText());
    beanani.setTipo_Ani(combo_tipo_Animal.getSelectedItem().toString());
    beanani.setFk_cod_Clie(Integer.parseInt(campo_cod_dono.getText()));
   
        
    DaoAnimal daoAnimal = new DaoAnimal(); // cria objeto para acessar os metodos sql
    
    
    daoAnimal.inserirDados(beanani); // coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    JOptionPane.showMessageDialog(null, "Cadastro realizou certim");
    }
    // Método de Listar Produtos na Tabela
      public void ListarProduto(){
        try {
            DaoProduto daoprod = new DaoProduto(); // criar o objeto com o metodo de listagem
            
            List<BeanProduto> listadeprodutos = daoprod.ListadeProduto(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelaprod = (DefaultTableModel) table_Produto.getModel();
            tabelaprod.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanProduto prod : listadeprodutos){
                BeanFornecedor bf = new BeanFornecedor();// cria um objeto  da classe bean que recebe os valores da lista
            tabelaprod.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
            prod.getCod_Prod(), // insere as informações correspondentes em cada coluna
                prod.getNome_Prod(),
                prod.getPreco_Prod(),
                prod.forn.getNome_Forn()
                
            
            
            
            });
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Produto"+e);
        }
    
    }
    
    //Método de Cadastrar o Produto
    
    public void CadastrarProduto(){
    BeanProduto beanprod = new BeanProduto(); // cria objeto para acessar as variaveis
   
    //seta nas variaveis os valores dos campos
   beanprod.setNome_Prod(campo_nome_Produto.getText());
    beanprod.setPreco_Prod(Double.parseDouble((campo_preco_Produto.getText())));
    beanprod.setFk_cod_Forn(Integer.parseInt(campo_cod_Fornecedor_Produto.getText()));
   
        
    DaoProduto daoprod = new DaoProduto(); // cria objeto para acessar os metodos sql
    
    
    daoprod.inserirDados(beanprod); // coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    }
   //Método de atualizar o cadastro de Produto
    
    public void AtualizarProdutos(){
     BeanProduto beanprod = new BeanProduto(); // cria objeto para acessar as variaveis
    
    //seta nas variaveis os valores dos campos
  beanprod.setNome_Prod(campo_nome_Produto.getText());
    beanprod.setPreco_Prod(Double.parseDouble((campo_preco_Produto.getText())));
    beanprod.forn.setNome_Forn(campo_nome_Fornecedor_Produto.getText());
        
    DaoProduto daoProduto = new DaoProduto(); // cria objeto para acessar os metodos sql
    
    daoProduto.AlterarProduto(beanprod);// coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    
    
    }
    // Método de Listar Fornecedores na Tabela
      public void ListarFornecedores(){
        try {
            DaoFornecedor daoforn = new DaoFornecedor(); // criar o objeto com o metodo de listagem
            
            List<BeanFornecedor> listadefornecedores = daoforn.ListadeFornecedor(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelaforn = (DefaultTableModel) table_Fornecedor.getModel();
            tabelaforn.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanFornecedor forn : listadefornecedores){ // cria um objeto  da classe bean que recebe os valores da lista
            tabelaforn.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
            forn.getCod_Forn(), // insere as informações correspondentes em cada coluna
                forn.getNome_Forn(),
                forn.getCnpj_Form(),
                forn.getEndereco_Forn()
                
            
            
            
            });
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Fornecedor"+e);
        }
    
    }
    public void ListarFornecedoresnoProduto(){
        try {
            DaoFornecedor daoforn = new DaoFornecedor(); // criar o objeto com o metodo de listagem
            
            List<BeanFornecedor> listadefornecedores = daoforn.ListadeFornecedor(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelaforn = (DefaultTableModel) table_Fornecedor_Produto.getModel();
            tabelaforn.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanFornecedor forn : listadefornecedores){ // cria um objeto  da classe bean que recebe os valores da lista
            tabelaforn.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
            forn.getCod_Forn(), // insere as informações correspondentes em cada coluna
                forn.getNome_Forn(),
                forn.getCnpj_Form(),
                forn.getEndereco_Forn()
                
            
            
            
            });
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Fornecedor"+e);
        }
    
    }
    //Método de Cadastrar o Fornecedor
    
    public void CadastrarFornecedor(){
    BeanFornecedor beanforn = new BeanFornecedor(); // cria objeto para acessar as variaveis
    
    //seta nas variaveis os valores dos campos
   beanforn.setNome_Forn(campo_nome_Fornecedor.getText());
    beanforn.setCnpj_Form(Integer.parseInt(campo_cnpj_Fornecedor.getText()));
    beanforn.setEndereco_Forn(campo_endereco_Fornecedor.getText());
   
        
    DaoFornecedor daoforn = new DaoFornecedor(); // cria objeto para acessar os metodos sql
    
    
    daoforn.inserirDados(beanforn); // coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    }
   //Método de atualizar o cadastro de Fornecedor
    
    public void AtualizarFornecedor(){
     BeanFornecedor beanforn = new BeanFornecedor(); // cria objeto para acessar as variaveis
    
    //seta nas variaveis os valores dos campos
    beanforn.setCod_Forn(Integer.parseInt(campo_cod_Fornecedor.getText()));
      beanforn.setNome_Forn(campo_nome_Fornecedor.getText());
    beanforn.setCnpj_Form(Integer.parseInt(campo_cnpj_Fornecedor.getText()));
    beanforn.setEndereco_Forn(campo_endereco_Fornecedor.getText());
        
    DaoFornecedor daoFornecedor = new DaoFornecedor(); // cria objeto para acessar os metodos sql
    
    daoFornecedor.AlterarFornecedor(beanforn);// coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    
    
    }
    // Método de Listar Clientes na Tabela
      public void ListarClientes(){
        try {
            DaoCliente daoclie = new DaoCliente(); // criar o objeto com o metodo de listagem
            
            List<BeanCliente> listadeclientes = daoclie.ListadeCliente(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelaclie = (DefaultTableModel) table_Cliente.getModel();
            tabelaclie.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanCliente clie : listadeclientes){ // cria um objeto  da classe bean que recebe os valores da lista
            tabelaclie.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
            clie.getCod_Clie(), // insere as informações correspondentes em cada coluna
                clie.getNome_Clie(),
                clie.getCpf_Clie(),
                clie.getEndereco_Clie(),
                clie.getTelefone_Clie()
            
            
            
            });
            
            
            }
        } catch (Exception e) {
        }
    
    }
    
    //Método de Cadastrar o Cliente
    
    public void CadastrarCliente(){
    BeanCliente beanClie = new BeanCliente(); // cria objeto para acessar as variaveis
    
    //seta nas variaveis os valores dos campos
   beanClie.setNome_Clie(campo_nome_Cliente.getText());
    beanClie.setCpf_Clie(Integer.parseInt(campo_cpf_Cliente.getText()));
    beanClie.setEndereco_Clie(campo_endereco_Cliente.getText());
    beanClie.setTelefone_Clie(campo_telefone_Cliente.getText());
        
    DaoCliente daoclie = new DaoCliente(); // cria objeto para acessar os metodos sql
    
    
    daoclie.inserirDados(beanClie); // coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    }
   //Método de atualizar o cadastro de Cliente
    
    public void AtualizarCliente(){
     BeanCliente beanClie = new BeanCliente(); // cria objeto para acessar as variaveis
    
    //seta nas variaveis os valores dos campos
    beanClie.setCod_Clie(Integer.parseInt(campo_cod_Cliente.getText()));
    beanClie.setNome_Clie(campo_nome_Cliente.getText());
    beanClie.setCpf_Clie(Integer.parseInt(campo_cpf_Cliente.getText()));
    beanClie.setEndereco_Clie(campo_endereco_Cliente.getText());
    beanClie.setTelefone_Clie(campo_telefone_Cliente.getText());
        
    DaoCliente daoclie = new DaoCliente(); // cria objeto para acessar os metodos sql
    
    daoclie.AlterarCliente(beanClie);// coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    
    
    }
    //Método de atualizar o cadastro de Funcionario
    
    public void AtualizarFuncionario(){
     BeanFuncionario beanfunc = new BeanFuncionario(); // cria objeto para acessar as variaveis
    
    //seta nas variaveis os valores dos campos
    beanfunc.setCod_Func(Integer.parseInt(campo_cod_Funcionario.getText()));
    beanfunc.setNome_Func(campo_nome_Funcionario.getText());
    beanfunc.setCpf_Func(Integer.parseInt(campo_cpf_Funcionario.getText()));
    beanfunc.setEndereco_Func(campo_endereco_Funcionario.getText());
    beanfunc.setTelefone_Func(campo_telefone_Funcionario1.getText());
        
    DaoFuncionario daofunc = new DaoFuncionario(); // cria objeto para acessar os metodos sql
    
    daofunc.AlterarFuncionario(beanfunc);// coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    
    
    }
    
    //Método de Cadastrar o funcionário
    
    public void CadastrarFuncionario(){
    BeanFuncionario beanfunc = new BeanFuncionario(); // cria objeto para acessar as variaveis
    
    //seta nas variaveis os valores dos campos
    
    beanfunc.setNome_Func(campo_nome_Funcionario.getText());
    beanfunc.setCpf_Func(Integer.parseInt(campo_cpf_Funcionario.getText()));
    beanfunc.setEndereco_Func(campo_endereco_Funcionario.getText());
    beanfunc.setTelefone_Func(campo_telefone_Funcionario1.getText());
        
    DaoFuncionario daofunc = new DaoFuncionario(); // cria objeto para acessar os metodos sql
    
    daofunc.inserirDados(beanfunc); // coloca o objeto bean para automaticamente ele usar os valores que foram setados 
    
    }
    
    // Método de listar os Funcionarios na Tabela
    
    public void ListarFuncionario(){
        try {
            DaoFuncionario daofunc = new DaoFuncionario(); // criar o objeto com o metodo de listagem
            
            List<BeanFuncionario> listadefuncionarios = daofunc.ListadeFuncionario(); // criar a lista que recebe a lista do metodo
            
            // cria um objeto que recebe os valores pra setar na tabela
            
            DefaultTableModel tabelafunc = (DefaultTableModel) table_Funcionário.getModel();
            tabelafunc.setNumRows(0);
            // cria o laço que joga os valores no objeto
            
            for(BeanFuncionario func : listadefuncionarios){ // cria um objeto  da classe bean que recebe os valores da lista
            tabelafunc.addRow(new Object[]{ // adiciona uma lista no objeto para cada dado retornado da lista
            func.getCod_Func(), // insere as informações correspondentes em cada coluna
                func.getNome_Func(),
                func.getCpf_Func(),
                func.getEndereco_Func(),
                func.getTelefone_Func()
            
            
            
            });
            
            
            }
        } catch (Exception e) {
        }
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        label_cachorroMexicano = new javax.swing.JLabel();
        label_cachorroMexicano1 = new javax.swing.JLabel();
        label_titulo_Menu = new javax.swing.JLabel();
        painel_Servico = new javax.swing.JPanel();
        frame_dono = new javax.swing.JInternalFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_Cliente_Dono = new javax.swing.JTable();
        bt_frame_close = new javax.swing.JButton();
        label_Titulo_Serviço = new javax.swing.JLabel();
        label_tipo_Animal = new javax.swing.JLabel();
        bt_Salvar_Servico = new javax.swing.JButton();
        bt_alterar_Servico = new javax.swing.JButton();
        bt_limpar_Servico = new javax.swing.JButton();
        campo_nome_Animal_Servico = new javax.swing.JTextField();
        label_descricao_Servico = new javax.swing.JLabel();
        combo_tipo_Animal = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_Animal = new javax.swing.JTable();
        label_nome_Animal = new javax.swing.JLabel();
        campo_nome_Animal = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        bt_BuscarDono = new javax.swing.JButton();
        bt_salvarAnimal = new javax.swing.JButton();
        label_nome_Dono_Servico = new javax.swing.JLabel();
        campo_nome_Dono_Servico = new javax.swing.JTextField();
        label_nome_Funcionario_Servico1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_Funcionário_Servico = new javax.swing.JTable();
        campo_nome_Funcionario_Servico = new javax.swing.JTextField();
        campo_nome_Dono = new javax.swing.JTextField();
        label_nome_Dono = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txt_descricao = new javax.swing.JTextArea();
        label_nome_Animal_Servico1 = new javax.swing.JLabel();
        label_Tabelabixo = new javax.swing.JLabel();
        label_TabelaFuncionarios = new javax.swing.JLabel();
        back_painel_Servico = new javax.swing.JLabel();
        campo_cod_Func_Servico = new javax.swing.JTextField();
        campo_cod_Ani = new javax.swing.JTextField();
        campo_cod_User_servico = new javax.swing.JTextField();
        campo_cod_dono = new javax.swing.JTextField();
        painel_Cliente = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Cliente = new javax.swing.JTable();
        label_Titulo_Cliente = new javax.swing.JLabel();
        campo_endereco_Cliente = new javax.swing.JTextField();
        label_endereco_Cliente = new javax.swing.JLabel();
        label_nome_Cliente = new javax.swing.JLabel();
        campo_nome_Cliente = new javax.swing.JTextField();
        label_cpf_Aviso_Cliente = new javax.swing.JLabel();
        campo_cpf_Cliente = new javax.swing.JTextField();
        label_cpf_Cliente = new javax.swing.JLabel();
        campo_telefone_Cliente = new javax.swing.JTextField();
        label_telefone_Cliente = new javax.swing.JLabel();
        bt_Salvar_Cliente = new javax.swing.JButton();
        bt_alterar_Cliente = new javax.swing.JButton();
        bt_limpar_Cliente = new javax.swing.JButton();
        back_painel_Cliente = new javax.swing.JLabel();
        campo_cod_Cliente = new javax.swing.JTextField();
        painel_Fornecedor = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Fornecedor = new javax.swing.JTable();
        label_Titulo_Fornecedor = new javax.swing.JLabel();
        campo_endereco_Fornecedor = new javax.swing.JTextField();
        label_endereco_Fornecedor = new javax.swing.JLabel();
        label_nome_Fornecedor = new javax.swing.JLabel();
        campo_nome_Fornecedor = new javax.swing.JTextField();
        label_cnpj_Aviso = new javax.swing.JLabel();
        campo_cnpj_Fornecedor = new javax.swing.JTextField();
        label_cpf_Cliente1 = new javax.swing.JLabel();
        bt_Salvar_Fornecedor = new javax.swing.JButton();
        bt_alterar_Fornecedor = new javax.swing.JButton();
        bt_limpar_Fornecedor = new javax.swing.JButton();
        back_painel_Fornecedor = new javax.swing.JLabel();
        campo_cod_Fornecedor = new javax.swing.JTextField();
        painel_Produto = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_Produto = new javax.swing.JTable();
        label_Titulo_Produto = new javax.swing.JLabel();
        campo_preco_Produto = new javax.swing.JTextField();
        label_preco_Produto = new javax.swing.JLabel();
        label_nome_Fornecedor_Produto = new javax.swing.JLabel();
        campo_nome_Fornecedor_Produto = new javax.swing.JTextField();
        bt_Salvar_Produto = new javax.swing.JButton();
        bt_alterar_Produto = new javax.swing.JButton();
        bt_limpar_Produto = new javax.swing.JButton();
        campo_nome_Produto = new javax.swing.JTextField();
        label_nome_Produto = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_Fornecedor_Produto = new javax.swing.JTable();
        back_painel_Produto = new javax.swing.JLabel();
        campo_cod_Fornecedor_Produto = new javax.swing.JTextField();
        campo_cod_Produto = new javax.swing.JTextField();
        painel_Funcionário = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Funcionário = new javax.swing.JTable();
        label_Titulo_Funcionario = new javax.swing.JLabel();
        campo_endereco_Funcionario = new javax.swing.JTextField();
        label_telefone_FunC = new javax.swing.JLabel();
        label_nome_Func = new javax.swing.JLabel();
        campo_nome_Funcionario = new javax.swing.JTextField();
        label_cpf_Aviso = new javax.swing.JLabel();
        campo_cpf_Funcionario = new javax.swing.JTextField();
        label_cpf_FunC = new javax.swing.JLabel();
        campo_telefone_Funcionario1 = new javax.swing.JTextField();
        label_telefone_FunC1 = new javax.swing.JLabel();
        bt_Salvar_Funcionario = new javax.swing.JButton();
        bt_alterar_Funcionario = new javax.swing.JButton();
        bt_limpar_Funcionario = new javax.swing.JButton();
        back_painel_Funci = new javax.swing.JLabel();
        campo_cod_Funcionario = new javax.swing.JTextField();
        painel_Menu = new javax.swing.JPanel();
        bt_Venda = new javax.swing.JButton();
        bt_Estoque = new javax.swing.JButton();
        back_painel_Menu = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menu_Controle = new javax.swing.JMenu();
        menuiten_Funcionário = new javax.swing.JMenuItem();
        menuiten_Cliente = new javax.swing.JMenuItem();
        menuiten_Fornecedor = new javax.swing.JMenuItem();
        menuiten_Produto = new javax.swing.JMenuItem();
        menuiten_Servico = new javax.swing.JMenuItem();
        menu_VoltarMenu = new javax.swing.JMenu();
        sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1280, -1));
        getContentPane().add(label_cachorroMexicano, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 60, 40));
        getContentPane().add(label_cachorroMexicano1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 60, 40));

        label_titulo_Menu.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label_titulo_Menu.setText("A A FALOU -  PET SHOP");
        getContentPane().add(label_titulo_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 260, -1));

        painel_Servico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        frame_dono.setVisible(true);
        frame_dono.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Cliente_Dono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Cliente_Dono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Cliente_DonoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_Cliente_Dono);
        if (table_Cliente_Dono.getColumnModel().getColumnCount() > 0) {
            table_Cliente_Dono.getColumnModel().getColumn(0).setResizable(false);
            table_Cliente_Dono.getColumnModel().getColumn(1).setResizable(false);
            table_Cliente_Dono.getColumnModel().getColumn(2).setResizable(false);
            table_Cliente_Dono.getColumnModel().getColumn(3).setResizable(false);
            table_Cliente_Dono.getColumnModel().getColumn(4).setResizable(false);
            table_Cliente_Dono.getColumnModel().getColumn(4).setHeaderValue("Telefone");
        }

        frame_dono.getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 460, 230));

        bt_frame_close.setText("OK");
        bt_frame_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_frame_closeActionPerformed(evt);
            }
        });
        frame_dono.getContentPane().add(bt_frame_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 70, -1));

        painel_Servico.add(frame_dono, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        label_Titulo_Serviço.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_Titulo_Serviço.setForeground(new java.awt.Color(0, 0, 0));
        label_Titulo_Serviço.setText("Serviço");
        painel_Servico.add(label_Titulo_Serviço, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, -1, -1));

        label_tipo_Animal.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_tipo_Animal.setForeground(new java.awt.Color(0, 0, 0));
        label_tipo_Animal.setText("Tipo");
        painel_Servico.add(label_tipo_Animal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        bt_Salvar_Servico.setBackground(new java.awt.Color(102, 255, 102));
        bt_Salvar_Servico.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        bt_Salvar_Servico.setForeground(new java.awt.Color(0, 0, 0));
        bt_Salvar_Servico.setText("Salvar Serviço");
        bt_Salvar_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Salvar_ServicoActionPerformed(evt);
            }
        });
        painel_Servico.add(bt_Salvar_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 170, 160, 60));

        bt_alterar_Servico.setBackground(new java.awt.Color(255, 255, 51));
        bt_alterar_Servico.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_alterar_Servico.setForeground(new java.awt.Color(0, 0, 0));
        bt_alterar_Servico.setText("Alterar Dado");
        bt_alterar_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_ServicoAção(evt);
            }
        });
        painel_Servico.add(bt_alterar_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 130, 30));

        bt_limpar_Servico.setBackground(new java.awt.Color(250, 66, 66));
        bt_limpar_Servico.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_limpar_Servico.setForeground(new java.awt.Color(0, 0, 0));
        bt_limpar_Servico.setText("Limpar campos");
        bt_limpar_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpar_ServicoAção(evt);
            }
        });
        painel_Servico.add(bt_limpar_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 110, 130, 30));

        campo_nome_Animal_Servico.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Animal_Servico.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Animal_Servico.setEnabled(false);
        campo_nome_Animal_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_Animal_ServicoActionPerformed(evt);
            }
        });
        painel_Servico.add(campo_nome_Animal_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 280, 50));

        label_descricao_Servico.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_descricao_Servico.setForeground(new java.awt.Color(0, 0, 0));
        label_descricao_Servico.setText("Descrição do Serviço");
        painel_Servico.add(label_descricao_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, -1));

        combo_tipo_Animal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Tipo de Animal", "Gato", "Cachorro" }));
        combo_tipo_Animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipo_AnimalActionPerformed(evt);
            }
        });
        painel_Servico.add(combo_tipo_Animal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 280, -1));

        table_Animal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Tipo", "Dono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Animal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_AnimalMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table_Animal);
        if (table_Animal.getColumnModel().getColumnCount() > 0) {
            table_Animal.getColumnModel().getColumn(0).setResizable(false);
            table_Animal.getColumnModel().getColumn(1).setResizable(false);
            table_Animal.getColumnModel().getColumn(2).setResizable(false);
            table_Animal.getColumnModel().getColumn(3).setResizable(false);
        }

        painel_Servico.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 360, 110));

        label_nome_Animal.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Animal.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Animal.setText("Nome do animal");
        painel_Servico.add(label_nome_Animal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        campo_nome_Animal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Animal.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_AnimalActionPerformed(evt);
            }
        });
        painel_Servico.add(campo_nome_Animal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 280, 50));

        jSeparator3.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        painel_Servico.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 40, 270));

        jSeparator4.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        painel_Servico.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, 270));
        painel_Servico.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 580, 10));

        bt_BuscarDono.setText("Buscar");
        bt_BuscarDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BuscarDonoActionPerformed(evt);
            }
        });
        painel_Servico.add(bt_BuscarDono, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, -1, -1));

        bt_salvarAnimal.setBackground(new java.awt.Color(0, 204, 0));
        bt_salvarAnimal.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_salvarAnimal.setForeground(new java.awt.Color(0, 0, 0));
        bt_salvarAnimal.setText("Salvar");
        bt_salvarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarAnimalActionPerformed(evt);
            }
        });
        painel_Servico.add(bt_salvarAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 110, -1));

        label_nome_Dono_Servico.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Dono_Servico.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Dono_Servico.setText("Dono");
        painel_Servico.add(label_nome_Dono_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, -1));

        campo_nome_Dono_Servico.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Dono_Servico.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Dono_Servico.setEnabled(false);
        campo_nome_Dono_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_Dono_ServicoActionPerformed(evt);
            }
        });
        painel_Servico.add(campo_nome_Dono_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 280, 50));

        label_nome_Funcionario_Servico1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Funcionario_Servico1.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Funcionario_Servico1.setText("Funcionário Responsável");
        painel_Servico.add(label_nome_Funcionario_Servico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        table_Funcionário_Servico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Funcionário_Servico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Funcionário_ServicoMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table_Funcionário_Servico);
        if (table_Funcionário_Servico.getColumnModel().getColumnCount() > 0) {
            table_Funcionário_Servico.getColumnModel().getColumn(0).setResizable(false);
            table_Funcionário_Servico.getColumnModel().getColumn(1).setResizable(false);
            table_Funcionário_Servico.getColumnModel().getColumn(2).setResizable(false);
            table_Funcionário_Servico.getColumnModel().getColumn(3).setResizable(false);
            table_Funcionário_Servico.getColumnModel().getColumn(4).setResizable(false);
            table_Funcionário_Servico.getColumnModel().getColumn(4).setHeaderValue("Telefone");
        }

        painel_Servico.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 480, 110));

        campo_nome_Funcionario_Servico.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Funcionario_Servico.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Funcionario_Servico.setEnabled(false);
        campo_nome_Funcionario_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_Funcionario_ServicoActionPerformed(evt);
            }
        });
        painel_Servico.add(campo_nome_Funcionario_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 280, 50));

        campo_nome_Dono.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Dono.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Dono.setEnabled(false);
        campo_nome_Dono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_DonoActionPerformed(evt);
            }
        });
        painel_Servico.add(campo_nome_Dono, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 280, 50));

        label_nome_Dono.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Dono.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Dono.setText("Dono");
        painel_Servico.add(label_nome_Dono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        txt_descricao.setColumns(20);
        txt_descricao.setRows(5);
        jScrollPane9.setViewportView(txt_descricao);

        painel_Servico.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 470, 120));

        label_nome_Animal_Servico1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Animal_Servico1.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Animal_Servico1.setText("Animal");
        painel_Servico.add(label_nome_Animal_Servico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        label_Tabelabixo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        label_Tabelabixo.setForeground(new java.awt.Color(0, 0, 0));
        label_Tabelabixo.setText("Tabela dos Animais");
        painel_Servico.add(label_Tabelabixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        label_TabelaFuncionarios.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        label_TabelaFuncionarios.setForeground(new java.awt.Color(0, 0, 0));
        label_TabelaFuncionarios.setText("Tabela dos Funcionários");
        painel_Servico.add(label_TabelaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));
        painel_Servico.add(back_painel_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -38, 1290, 720));

        campo_cod_Func_Servico.setEnabled(false);
        painel_Servico.add(campo_cod_Func_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        campo_cod_Ani.setEnabled(false);
        painel_Servico.add(campo_cod_Ani, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        campo_cod_User_servico.setEnabled(false);
        painel_Servico.add(campo_cod_User_servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        campo_cod_dono.setEnabled(false);
        painel_Servico.add(campo_cod_dono, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        getContentPane().add(painel_Servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1280, 700));

        painel_Cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Cliente);
        if (table_Cliente.getColumnModel().getColumnCount() > 0) {
            table_Cliente.getColumnModel().getColumn(0).setResizable(false);
            table_Cliente.getColumnModel().getColumn(1).setResizable(false);
            table_Cliente.getColumnModel().getColumn(2).setResizable(false);
            table_Cliente.getColumnModel().getColumn(3).setResizable(false);
            table_Cliente.getColumnModel().getColumn(4).setResizable(false);
        }

        painel_Cliente.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 460, 110));

        label_Titulo_Cliente.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_Titulo_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        label_Titulo_Cliente.setText("Cliente");
        painel_Cliente.add(label_Titulo_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));

        campo_endereco_Cliente.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_endereco_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_endereco_ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_endereco_ClienteMouseExited(evt);
            }
        });
        campo_endereco_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_endereco_ClienteActionPerformed(evt);
            }
        });
        painel_Cliente.add(campo_endereco_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 600, -1));

        label_endereco_Cliente.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_endereco_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        label_endereco_Cliente.setText("Endereço");
        painel_Cliente.add(label_endereco_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, -1, -1));

        label_nome_Cliente.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Cliente.setText("Nome Completo");
        painel_Cliente.add(label_nome_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        campo_nome_Cliente.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Cliente.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_ClienteActionPerformed(evt);
            }
        });
        painel_Cliente.add(campo_nome_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 620, 50));

        label_cpf_Aviso_Cliente.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        label_cpf_Aviso_Cliente.setForeground(new java.awt.Color(255, 0, 0));
        label_cpf_Aviso_Cliente.setText("*Somente os números. Não digite \".\" nem \"-\"");
        painel_Cliente.add(label_cpf_Aviso_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 320, 20));

        campo_cpf_Cliente.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_cpf_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_cpf_ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_cpf_ClienteMouseExited(evt);
            }
        });
        campo_cpf_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cpf_ClienteActionPerformed(evt);
            }
        });
        painel_Cliente.add(campo_cpf_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 260, 50));

        label_cpf_Cliente.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_cpf_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        label_cpf_Cliente.setText("CPF");
        painel_Cliente.add(label_cpf_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        campo_telefone_Cliente.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_telefone_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_telefone_ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_telefone_ClienteMouseExited(evt);
            }
        });
        campo_telefone_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_telefone_ClienteActionPerformed(evt);
            }
        });
        painel_Cliente.add(campo_telefone_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 360, -1));

        label_telefone_Cliente.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_telefone_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        label_telefone_Cliente.setText("Número");
        painel_Cliente.add(label_telefone_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        bt_Salvar_Cliente.setBackground(new java.awt.Color(102, 255, 102));
        bt_Salvar_Cliente.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        bt_Salvar_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        bt_Salvar_Cliente.setText("Salvar");
        bt_Salvar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Salvar_ClienteActionPerformed(evt);
            }
        });
        painel_Cliente.add(bt_Salvar_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 170, 150, 60));

        bt_alterar_Cliente.setBackground(new java.awt.Color(255, 255, 51));
        bt_alterar_Cliente.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_alterar_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        bt_alterar_Cliente.setText("Alterar Dado");
        bt_alterar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_ClienteAção(evt);
            }
        });
        painel_Cliente.add(bt_alterar_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 130, 30));

        bt_limpar_Cliente.setBackground(new java.awt.Color(250, 66, 66));
        bt_limpar_Cliente.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_limpar_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        bt_limpar_Cliente.setText("Limpar campos");
        bt_limpar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpar_ClienteAção(evt);
            }
        });
        painel_Cliente.add(bt_limpar_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 110, 130, 30));
        painel_Cliente.add(back_painel_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 2, 1290, 660));

        campo_cod_Cliente.setEnabled(false);
        painel_Cliente.add(campo_cod_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        getContentPane().add(painel_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 660));

        painel_Fornecedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CNPJ", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_FornecedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_Fornecedor);
        if (table_Fornecedor.getColumnModel().getColumnCount() > 0) {
            table_Fornecedor.getColumnModel().getColumn(0).setResizable(false);
            table_Fornecedor.getColumnModel().getColumn(1).setResizable(false);
            table_Fornecedor.getColumnModel().getColumn(2).setResizable(false);
            table_Fornecedor.getColumnModel().getColumn(3).setResizable(false);
        }

        painel_Fornecedor.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 460, 110));

        label_Titulo_Fornecedor.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_Titulo_Fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        label_Titulo_Fornecedor.setText("Fornecedor");
        painel_Fornecedor.add(label_Titulo_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));

        campo_endereco_Fornecedor.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_endereco_Fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_endereco_FornecedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_endereco_FornecedorMouseExited(evt);
            }
        });
        campo_endereco_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_endereco_FornecedorActionPerformed(evt);
            }
        });
        painel_Fornecedor.add(campo_endereco_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 600, -1));

        label_endereco_Fornecedor.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_endereco_Fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        label_endereco_Fornecedor.setText("Endereço");
        painel_Fornecedor.add(label_endereco_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        label_nome_Fornecedor.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Fornecedor.setText("Nome Completo");
        painel_Fornecedor.add(label_nome_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        campo_nome_Fornecedor.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Fornecedor.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_FornecedorActionPerformed(evt);
            }
        });
        painel_Fornecedor.add(campo_nome_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 620, 50));

        label_cnpj_Aviso.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        label_cnpj_Aviso.setForeground(new java.awt.Color(255, 0, 0));
        label_cnpj_Aviso.setText("*Somente os números. Não digite \".\" nem \"-\"");
        painel_Fornecedor.add(label_cnpj_Aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 320, 20));

        campo_cnpj_Fornecedor.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_cnpj_Fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_cnpj_FornecedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_cnpj_FornecedorMouseExited(evt);
            }
        });
        campo_cnpj_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cnpj_FornecedorActionPerformed(evt);
            }
        });
        painel_Fornecedor.add(campo_cnpj_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 260, 50));

        label_cpf_Cliente1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_cpf_Cliente1.setForeground(new java.awt.Color(0, 0, 0));
        label_cpf_Cliente1.setText("CNPJ");
        painel_Fornecedor.add(label_cpf_Cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        bt_Salvar_Fornecedor.setBackground(new java.awt.Color(102, 255, 102));
        bt_Salvar_Fornecedor.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        bt_Salvar_Fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        bt_Salvar_Fornecedor.setText("Salvar");
        bt_Salvar_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Salvar_FornecedorActionPerformed(evt);
            }
        });
        painel_Fornecedor.add(bt_Salvar_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 170, 150, 60));

        bt_alterar_Fornecedor.setBackground(new java.awt.Color(255, 255, 51));
        bt_alterar_Fornecedor.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_alterar_Fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        bt_alterar_Fornecedor.setText("Alterar Dado");
        bt_alterar_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_FornecedorAção(evt);
            }
        });
        painel_Fornecedor.add(bt_alterar_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 130, 30));

        bt_limpar_Fornecedor.setBackground(new java.awt.Color(250, 66, 66));
        bt_limpar_Fornecedor.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_limpar_Fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        bt_limpar_Fornecedor.setText("Limpar campos");
        bt_limpar_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpar_FornecedorAção(evt);
            }
        });
        painel_Fornecedor.add(bt_limpar_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 110, 130, 30));
        painel_Fornecedor.add(back_painel_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 2, 1290, 660));

        campo_cod_Fornecedor.setEnabled(false);
        painel_Fornecedor.add(campo_cod_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        getContentPane().add(painel_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, -1, 650));

        painel_Produto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço", "Fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table_Produto);
        if (table_Produto.getColumnModel().getColumnCount() > 0) {
            table_Produto.getColumnModel().getColumn(0).setResizable(false);
            table_Produto.getColumnModel().getColumn(1).setResizable(false);
            table_Produto.getColumnModel().getColumn(2).setResizable(false);
            table_Produto.getColumnModel().getColumn(3).setResizable(false);
        }

        painel_Produto.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 460, 110));

        label_Titulo_Produto.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_Titulo_Produto.setForeground(new java.awt.Color(0, 0, 0));
        label_Titulo_Produto.setText("Produto");
        painel_Produto.add(label_Titulo_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, -1, -1));

        campo_preco_Produto.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_preco_Produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_preco_ProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_preco_ProdutoMouseExited(evt);
            }
        });
        campo_preco_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_preco_ProdutoActionPerformed(evt);
            }
        });
        painel_Produto.add(campo_preco_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 150, -1));

        label_preco_Produto.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_preco_Produto.setForeground(new java.awt.Color(0, 0, 0));
        label_preco_Produto.setText("Preço");
        painel_Produto.add(label_preco_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        label_nome_Fornecedor_Produto.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Fornecedor_Produto.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Fornecedor_Produto.setText("Nome do Fornecedor ");
        painel_Produto.add(label_nome_Fornecedor_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));

        campo_nome_Fornecedor_Produto.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Fornecedor_Produto.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Fornecedor_Produto.setEnabled(false);
        campo_nome_Fornecedor_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_Fornecedor_ProdutoActionPerformed(evt);
            }
        });
        painel_Produto.add(campo_nome_Fornecedor_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 620, 50));

        bt_Salvar_Produto.setBackground(new java.awt.Color(102, 255, 102));
        bt_Salvar_Produto.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        bt_Salvar_Produto.setForeground(new java.awt.Color(0, 0, 0));
        bt_Salvar_Produto.setText("Salvar");
        bt_Salvar_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Salvar_ProdutoActionPerformed(evt);
            }
        });
        painel_Produto.add(bt_Salvar_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 170, 150, 60));

        bt_alterar_Produto.setBackground(new java.awt.Color(255, 255, 51));
        bt_alterar_Produto.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_alterar_Produto.setForeground(new java.awt.Color(0, 0, 0));
        bt_alterar_Produto.setText("Alterar Dado");
        bt_alterar_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_ProdutoAção(evt);
            }
        });
        painel_Produto.add(bt_alterar_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 130, 30));

        bt_limpar_Produto.setBackground(new java.awt.Color(250, 66, 66));
        bt_limpar_Produto.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_limpar_Produto.setForeground(new java.awt.Color(0, 0, 0));
        bt_limpar_Produto.setText("Limpar campos");
        bt_limpar_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpar_ProdutoAção(evt);
            }
        });
        painel_Produto.add(bt_limpar_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 110, 130, 30));

        campo_nome_Produto.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Produto.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_ProdutoActionPerformed(evt);
            }
        });
        painel_Produto.add(campo_nome_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 620, 50));

        label_nome_Produto.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Produto.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Produto.setText("Nome ");
        painel_Produto.add(label_nome_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        table_Fornecedor_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CNPJ", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Fornecedor_Produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Fornecedor_ProdutoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_Fornecedor_Produto);
        if (table_Fornecedor_Produto.getColumnModel().getColumnCount() > 0) {
            table_Fornecedor_Produto.getColumnModel().getColumn(0).setResizable(false);
            table_Fornecedor_Produto.getColumnModel().getColumn(1).setResizable(false);
            table_Fornecedor_Produto.getColumnModel().getColumn(2).setResizable(false);
            table_Fornecedor_Produto.getColumnModel().getColumn(3).setResizable(false);
        }

        painel_Produto.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 460, 110));
        painel_Produto.add(back_painel_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 2, 1290, 660));

        campo_cod_Fornecedor_Produto.setEnabled(false);
        painel_Produto.add(campo_cod_Fornecedor_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        campo_cod_Produto.setEnabled(false);
        painel_Produto.add(campo_cod_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        getContentPane().add(painel_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, -1, 650));

        painel_Funcionário.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Funcionário.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Funcionário.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_FuncionárioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Funcionário);
        if (table_Funcionário.getColumnModel().getColumnCount() > 0) {
            table_Funcionário.getColumnModel().getColumn(0).setResizable(false);
            table_Funcionário.getColumnModel().getColumn(1).setResizable(false);
            table_Funcionário.getColumnModel().getColumn(2).setResizable(false);
            table_Funcionário.getColumnModel().getColumn(3).setResizable(false);
            table_Funcionário.getColumnModel().getColumn(4).setResizable(false);
            table_Funcionário.getColumnModel().getColumn(4).setHeaderValue("Telefone");
        }

        painel_Funcionário.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 460, 110));

        label_Titulo_Funcionario.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_Titulo_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        label_Titulo_Funcionario.setText("Funcionário");
        painel_Funcionário.add(label_Titulo_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));

        campo_endereco_Funcionario.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_endereco_Funcionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_endereco_FuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_endereco_FuncionarioMouseExited(evt);
            }
        });
        campo_endereco_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_endereco_FuncionarioActionPerformed(evt);
            }
        });
        painel_Funcionário.add(campo_endereco_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 600, -1));

        label_telefone_FunC.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_telefone_FunC.setForeground(new java.awt.Color(0, 0, 0));
        label_telefone_FunC.setText("Endereço");
        painel_Funcionário.add(label_telefone_FunC, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, -1, -1));

        label_nome_Func.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_nome_Func.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_Func.setText("Nome Completo");
        painel_Funcionário.add(label_nome_Func, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        campo_nome_Funcionario.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_nome_Funcionario.setCaretColor(new java.awt.Color(0, 0, 0));
        campo_nome_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nome_FuncionarioActionPerformed(evt);
            }
        });
        painel_Funcionário.add(campo_nome_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 620, 50));

        label_cpf_Aviso.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        label_cpf_Aviso.setForeground(new java.awt.Color(255, 0, 0));
        label_cpf_Aviso.setText("*Somente os números. Não digite \".\" nem \"-\"");
        painel_Funcionário.add(label_cpf_Aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 320, 20));

        campo_cpf_Funcionario.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_cpf_Funcionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_cpf_FuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_cpf_FuncionarioMouseExited(evt);
            }
        });
        campo_cpf_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cpf_FuncionarioActionPerformed(evt);
            }
        });
        painel_Funcionário.add(campo_cpf_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 260, 50));

        label_cpf_FunC.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_cpf_FunC.setForeground(new java.awt.Color(0, 0, 0));
        label_cpf_FunC.setText("CPF");
        painel_Funcionário.add(label_cpf_FunC, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        campo_telefone_Funcionario1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        campo_telefone_Funcionario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_telefone_Funcionario1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo_telefone_Funcionario1MouseExited(evt);
            }
        });
        campo_telefone_Funcionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_telefone_Funcionario1ActionPerformed(evt);
            }
        });
        painel_Funcionário.add(campo_telefone_Funcionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 360, -1));

        label_telefone_FunC1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        label_telefone_FunC1.setForeground(new java.awt.Color(0, 0, 0));
        label_telefone_FunC1.setText("Número");
        painel_Funcionário.add(label_telefone_FunC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        bt_Salvar_Funcionario.setBackground(new java.awt.Color(102, 255, 102));
        bt_Salvar_Funcionario.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        bt_Salvar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        bt_Salvar_Funcionario.setText("Salvar");
        bt_Salvar_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_Salvar_FuncionarioActionPerformed(evt);
            }
        });
        painel_Funcionário.add(bt_Salvar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 170, 150, 60));

        bt_alterar_Funcionario.setBackground(new java.awt.Color(255, 255, 51));
        bt_alterar_Funcionario.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_alterar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        bt_alterar_Funcionario.setText("Alterar Dado");
        bt_alterar_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_FuncionarioAção(evt);
            }
        });
        painel_Funcionário.add(bt_alterar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 130, 30));

        bt_limpar_Funcionario.setBackground(new java.awt.Color(250, 66, 66));
        bt_limpar_Funcionario.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bt_limpar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        bt_limpar_Funcionario.setText("Limpar campos");
        bt_limpar_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpar_FuncionarioAção(evt);
            }
        });
        painel_Funcionário.add(bt_limpar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 110, 130, 30));
        painel_Funcionário.add(back_painel_Funci, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1290, 740));

        campo_cod_Funcionario.setEnabled(false);
        painel_Funcionário.add(campo_cod_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, -1));

        getContentPane().add(painel_Funcionário, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 660));

        painel_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_Venda.setBackground(new java.awt.Color(253, 159, 86));
        bt_Venda.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        bt_Venda.setForeground(new java.awt.Color(0, 0, 0));
        bt_Venda.setText("VENDA");
        bt_Venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_VendaActionPerformed(evt);
            }
        });
        painel_Menu.add(bt_Venda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 270, 60));

        bt_Estoque.setBackground(new java.awt.Color(253, 159, 86));
        bt_Estoque.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        bt_Estoque.setForeground(new java.awt.Color(0, 0, 0));
        bt_Estoque.setText("ESTOQUE");
        bt_Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EstoqueActionPerformed(evt);
            }
        });
        painel_Menu.add(bt_Estoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 230, 60));
        painel_Menu.add(back_painel_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 12, 1290, 720));

        getContentPane().add(painel_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        menu_Controle.setText("Controle");
        menu_Controle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        menuiten_Funcionário.setText("Funcionário");
        menuiten_Funcionário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuiten_FuncionárioActionPerformed(evt);
            }
        });
        menu_Controle.add(menuiten_Funcionário);

        menuiten_Cliente.setText("Cliente");
        menuiten_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuiten_ClienteActionPerformed(evt);
            }
        });
        menu_Controle.add(menuiten_Cliente);

        menuiten_Fornecedor.setText("Fornecedor");
        menuiten_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuiten_FornecedorActionPerformed(evt);
            }
        });
        menu_Controle.add(menuiten_Fornecedor);

        menuiten_Produto.setText("Produto");
        menuiten_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuiten_ProdutoActionPerformed(evt);
            }
        });
        menu_Controle.add(menuiten_Produto);

        menuiten_Servico.setText("Serviço");
        menuiten_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuiten_ServicoActionPerformed(evt);
            }
        });
        menu_Controle.add(menuiten_Servico);

        menu.add(menu_Controle);

        menu_VoltarMenu.setBackground(new java.awt.Color(0, 0, 0));
        menu_VoltarMenu.setText("Voltar ao Menu");
        menu_VoltarMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menu_VoltarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_VoltarMenuMouseClicked(evt);
            }
        });
        menu_VoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_VoltarMenuActionPerformed(evt);
            }
        });
        menu.add(menu_VoltarMenu);

        sair.setText("Sair");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        menu.add(sair);

        setJMenuBar(menu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//desbailitar os outros paineis e abrir só a do funcionário
    private void menuiten_FuncionárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuiten_FuncionárioActionPerformed
        painel_Menu.setVisible(false);
          
        painel_Cliente.setVisible(false);
        painel_Fornecedor.setVisible(false);
        painel_Produto.setVisible(false);
        painel_Servico.setVisible(false);
        painel_Funcionário.setVisible(true);
    }//GEN-LAST:event_menuiten_FuncionárioActionPerformed

    private void campo_endereco_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_endereco_FuncionarioActionPerformed
       
    }//GEN-LAST:event_campo_endereco_FuncionarioActionPerformed

    private void campo_nome_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_FuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_FuncionarioActionPerformed

    private void campo_endereco_FuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_endereco_FuncionarioMouseEntered
      
    }//GEN-LAST:event_campo_endereco_FuncionarioMouseEntered

    private void campo_endereco_FuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_endereco_FuncionarioMouseExited
      
    }//GEN-LAST:event_campo_endereco_FuncionarioMouseExited

    private void campo_cpf_FuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_cpf_FuncionarioMouseEntered
         label_cpf_Aviso.setVisible(true);
    }//GEN-LAST:event_campo_cpf_FuncionarioMouseEntered

    private void campo_cpf_FuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_cpf_FuncionarioMouseExited
       label_cpf_Aviso.setVisible(false);
    }//GEN-LAST:event_campo_cpf_FuncionarioMouseExited

    private void campo_cpf_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cpf_FuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cpf_FuncionarioActionPerformed

    private void campo_telefone_Funcionario1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_telefone_Funcionario1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_telefone_Funcionario1MouseEntered

    private void campo_telefone_Funcionario1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_telefone_Funcionario1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_telefone_Funcionario1MouseExited

    private void campo_telefone_Funcionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_telefone_Funcionario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_telefone_Funcionario1ActionPerformed

    private void bt_alterar_FuncionarioAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_FuncionarioAção
        try {
                    AtualizarFuncionario();
                        campo_nome_Funcionario.setText("");
        campo_cpf_Funcionario.setText("");
        campo_telefone_Funcionario1.setText("");
        campo_endereco_Funcionario.setText("");
        campo_cod_Funcionario.setText("");
                    JOptionPane.showMessageDialog(null, "Alteração Bem sucedida"); // se tudo tiver certo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Alteração deu erro"+e); // se der errado
        }

    }//GEN-LAST:event_bt_alterar_FuncionarioAção

    private void bt_limpar_FuncionarioAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpar_FuncionarioAção
          campo_nome_Funcionario.setText(""); // os campos são apagados colocando nada
        campo_cpf_Funcionario.setText("");
        campo_cod_Funcionario.setText("");
         campo_telefone_Funcionario1.setText("");
          campo_endereco_Funcionario.setText("");
    }//GEN-LAST:event_bt_limpar_FuncionarioAção

    private void campo_endereco_ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_endereco_ClienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_endereco_ClienteMouseEntered

    private void campo_endereco_ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_endereco_ClienteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_endereco_ClienteMouseExited

    private void campo_endereco_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_endereco_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_endereco_ClienteActionPerformed

    private void campo_nome_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_ClienteActionPerformed

    private void campo_cpf_ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_cpf_ClienteMouseEntered
        label_cpf_Aviso_Cliente.setVisible(true);
    }//GEN-LAST:event_campo_cpf_ClienteMouseEntered

    private void campo_cpf_ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_cpf_ClienteMouseExited
         label_cpf_Aviso_Cliente.setVisible(false);
    }//GEN-LAST:event_campo_cpf_ClienteMouseExited

    private void campo_cpf_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cpf_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cpf_ClienteActionPerformed

    private void campo_telefone_ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_telefone_ClienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_telefone_ClienteMouseEntered

    private void campo_telefone_ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_telefone_ClienteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_telefone_ClienteMouseExited

    private void campo_telefone_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_telefone_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_telefone_ClienteActionPerformed

    private void bt_alterar_ClienteAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_ClienteAção
 try {
                    AtualizarCliente();
                        campo_nome_Cliente.setText("");
        campo_cpf_Cliente.setText("");
        campo_telefone_Cliente.setText("");
        campo_endereco_Cliente.setText("");
        campo_cod_Cliente.setText("");
                    JOptionPane.showMessageDialog(null, "Alteração Bem sucedida"); // se tudo tiver certo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Alteração deu erro"+e); // se der errado
        }        
    }//GEN-LAST:event_bt_alterar_ClienteAção

    private void bt_limpar_ClienteAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpar_ClienteAção
        campo_nome_Cliente.setText("");
        campo_cpf_Cliente.setText("");
        campo_telefone_Cliente.setText("");
        campo_endereco_Cliente.setText("");
        campo_cod_Cliente.setText("");
    }//GEN-LAST:event_bt_limpar_ClienteAção

    private void campo_endereco_FornecedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_endereco_FornecedorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_endereco_FornecedorMouseEntered

    private void campo_endereco_FornecedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_endereco_FornecedorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_endereco_FornecedorMouseExited

    private void campo_endereco_FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_endereco_FornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_endereco_FornecedorActionPerformed

    private void campo_nome_FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_FornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_FornecedorActionPerformed

    private void campo_cnpj_FornecedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_cnpj_FornecedorMouseEntered
        label_cnpj_Aviso.setVisible(true); // habilita o aviso ao passar o mouse
    }//GEN-LAST:event_campo_cnpj_FornecedorMouseEntered

    private void campo_cnpj_FornecedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_cnpj_FornecedorMouseExited
        label_cnpj_Aviso.setVisible(false); // desabilita ao sair
    }//GEN-LAST:event_campo_cnpj_FornecedorMouseExited

    private void campo_cnpj_FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cnpj_FornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cnpj_FornecedorActionPerformed

    private void bt_alterar_FornecedorAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_FornecedorAção
        try {
                    AtualizarFornecedor();
       campo_nome_Fornecedor.setText(""); // seta nada nos textfields para apagar os textos
        campo_cnpj_Fornecedor.setText("");
        campo_endereco_Fornecedor.setText("");
        campo_cod_Fornecedor.setText("");
                    JOptionPane.showMessageDialog(null, "Alteração Bem sucedida"); // se tudo tiver certo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Alteração deu erro"+e); // se der errado
        }  
    }//GEN-LAST:event_bt_alterar_FornecedorAção

    private void bt_limpar_FornecedorAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpar_FornecedorAção
        campo_nome_Fornecedor.setText(""); // seta nada nos textfields para apagar os textos
        campo_cnpj_Fornecedor.setText("");
        campo_endereco_Fornecedor.setText("");
        campo_cod_Fornecedor.setText("");
    }//GEN-LAST:event_bt_limpar_FornecedorAção

    private void campo_preco_ProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_preco_ProdutoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_preco_ProdutoMouseEntered

    private void campo_preco_ProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_preco_ProdutoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_preco_ProdutoMouseExited

    private void campo_preco_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_preco_ProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_preco_ProdutoActionPerformed

    private void campo_nome_Fornecedor_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_Fornecedor_ProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_Fornecedor_ProdutoActionPerformed

    private void bt_alterar_ProdutoAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_ProdutoAção
 try {
           AtualizarProdutos();
            campo_nome_Fornecedor.setText("");
        campo_cnpj_Fornecedor.setText("");
        campo_endereco_Fornecedor.setText("");
        campo_cod_Fornecedor.setText("");
            JOptionPane.showMessageDialog(null, "Alteraçãp realizadinha"); // se funcionar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Alteração falhou: erro "+e); // se der erro
        }
    }//GEN-LAST:event_bt_alterar_ProdutoAção

    private void bt_limpar_ProdutoAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpar_ProdutoAção
       campo_nome_Produto.setText(""); // seta nada para apagar o espaço
       campo_preco_Produto.setText("");
       campo_nome_Fornecedor_Produto.setText("");
       campo_cod_Produto.setText("");
       campo_cod_Fornecedor_Produto.setText("");
    }//GEN-LAST:event_bt_limpar_ProdutoAção

    private void campo_nome_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_ProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_ProdutoActionPerformed

    private void bt_alterar_ServicoAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_ServicoAção
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_alterar_ServicoAção

    private void bt_limpar_ServicoAção(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpar_ServicoAção
        campo_nome_Animal.setText(""); // seta "" para apagar os dados
         campo_nome_Animal_Servico.setText("");
        combo_tipo_Animal.setSelectedIndex(0); // seleciona o index responsável por dizer a seleção
        campo_nome_Dono.setText("");
        campo_nome_Dono_Servico.setText("");
        campo_nome_Funcionario_Servico.setText("");
        txt_descricao.setText("");
    }//GEN-LAST:event_bt_limpar_ServicoAção

    private void campo_nome_Animal_ServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_Animal_ServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_Animal_ServicoActionPerformed

    private void campo_nome_AnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_AnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_AnimalActionPerformed

    private void bt_frame_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_frame_closeActionPerformed
        frame_dono.setVisible(false);
    }//GEN-LAST:event_bt_frame_closeActionPerformed

    private void campo_nome_Dono_ServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_Dono_ServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_Dono_ServicoActionPerformed

    private void campo_nome_Funcionario_ServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_Funcionario_ServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_Funcionario_ServicoActionPerformed

    private void campo_nome_DonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nome_DonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nome_DonoActionPerformed

    private void menuiten_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuiten_ClienteActionPerformed
        painel_Funcionário.setVisible(false);      
        painel_Fornecedor.setVisible(false);
        painel_Produto.setVisible(false);
        painel_Servico.setVisible(false);
        painel_Menu.setVisible(false); // desabilita o menu e habilita o painel de cliente
      painel_Cliente.setVisible(true);
    }//GEN-LAST:event_menuiten_ClienteActionPerformed

    private void menuiten_FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuiten_FornecedorActionPerformed
          painel_Funcionário.setVisible(false);
        painel_Cliente.setVisible(false);
      
        painel_Produto.setVisible(false);
        painel_Servico.setVisible(false);
        painel_Menu.setVisible(false); // desabilita o menu e habilita o painel de Fornecedor
      painel_Fornecedor.setVisible(true);
    }//GEN-LAST:event_menuiten_FornecedorActionPerformed

    private void menuiten_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuiten_ProdutoActionPerformed
          painel_Funcionário.setVisible(false);
        painel_Cliente.setVisible(false);
        painel_Fornecedor.setVisible(false);
    
        painel_Servico.setVisible(false);
        painel_Menu.setVisible(false); // desabilita o menu e habilita o painel de PRODUTO
      painel_Produto.setVisible(true);
     
    }//GEN-LAST:event_menuiten_ProdutoActionPerformed

    private void menuiten_ServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuiten_ServicoActionPerformed
  painel_Funcionário.setVisible(false);
        painel_Cliente.setVisible(false);
        painel_Fornecedor.setVisible(false);
        painel_Produto.setVisible(false);
       
        painel_Menu.setVisible(false); // desabilita o menu e habilita o painel de Serviço
      painel_Servico.setVisible(true);
    
    }//GEN-LAST:event_menuiten_ServicoActionPerformed

    private void combo_tipo_AnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipo_AnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipo_AnimalActionPerformed

    private void bt_BuscarDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BuscarDonoActionPerformed
        frame_dono.setVisible(true);
        ListarClientesDonos();
    }//GEN-LAST:event_bt_BuscarDonoActionPerformed

    private void menu_VoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_VoltarMenuActionPerformed

    }//GEN-LAST:event_menu_VoltarMenuActionPerformed

    private void menu_VoltarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_VoltarMenuMouseClicked
         painel_Funcionário.setVisible(false); // desabilita qualquer outro painel aberto
        painel_Cliente.setVisible(false);
        painel_Fornecedor.setVisible(false);
        painel_Produto.setVisible(false);
        painel_Servico.setVisible(false);
        
        painel_Menu.setVisible(true); // habilita painel do menu inicial
    }//GEN-LAST:event_menu_VoltarMenuMouseClicked

    private void bt_Salvar_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Salvar_FuncionarioActionPerformed
        try {
           CadastrarFuncionario();
            campo_nome_Funcionario.setText("");
        campo_cpf_Funcionario.setText("");
        campo_telefone_Funcionario1.setText("");
        campo_endereco_Funcionario.setText("");
        campo_cod_Funcionario.setText("");
            JOptionPane.showMessageDialog(null, "Cadastro realizadinho"); // se funcionar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro falhou: erro "+e); // se der erro
        }
        
    }//GEN-LAST:event_bt_Salvar_FuncionarioActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
ListarAnimal();
        ListarProduto();
        ListarFornecedores();
        ListarFornecedoresnoProduto();
        ListarClientes();
        ListarFuncionario(); // chama o metodo de listagem para aparecer
       ListarFuncionarioServico();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void table_FuncionárioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_FuncionárioMouseClicked
       
        // Método que pega o valor da tabela e seta nos campos
        
        campo_cod_Funcionario.setText(table_Funcionário.getValueAt(table_Funcionário.getSelectedRow(),0).toString());
        campo_nome_Funcionario.setText(table_Funcionário.getValueAt(table_Funcionário.getSelectedRow(),1).toString());
        campo_cpf_Funcionario.setText(table_Funcionário.getValueAt(table_Funcionário.getSelectedRow(),2).toString());
        campo_telefone_Funcionario1.setText(table_Funcionário.getValueAt(table_Funcionário.getSelectedRow(),4).toString());
        campo_endereco_Funcionario.setText(table_Funcionário.getValueAt(table_Funcionário.getSelectedRow(),3).toString());
    }//GEN-LAST:event_table_FuncionárioMouseClicked

    private void table_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ClienteMouseClicked
       // Método que pega o valor da tabela e seta nos campos
        
        campo_cod_Cliente.setText(table_Cliente.getValueAt(table_Cliente.getSelectedRow(),0).toString());
        campo_nome_Cliente.setText(table_Cliente.getValueAt(table_Cliente.getSelectedRow(),1).toString());
        campo_cpf_Cliente.setText(table_Cliente.getValueAt(table_Cliente.getSelectedRow(),2).toString());
        campo_telefone_Cliente.setText(table_Cliente.getValueAt(table_Cliente.getSelectedRow(),4).toString());
        campo_endereco_Cliente.setText(table_Cliente.getValueAt(table_Cliente.getSelectedRow(),3).toString());
    }//GEN-LAST:event_table_ClienteMouseClicked

    private void bt_Salvar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Salvar_ClienteActionPerformed
         try {
           CadastrarCliente();
            campo_nome_Cliente.setText("");
        campo_cpf_Cliente.setText("");
        campo_telefone_Cliente.setText("");
        campo_endereco_Cliente.setText("");
        campo_cod_Cliente.setText("");
            JOptionPane.showMessageDialog(null, "Cadastro realizadinho"); // se funcionar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro falhou: erro "+e); // se der erro
        }
    }//GEN-LAST:event_bt_Salvar_ClienteActionPerformed

    private void table_FornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_FornecedorMouseClicked
         // Método que pega o valor da tabela e seta nos campos
        
        campo_cod_Fornecedor.setText(table_Fornecedor.getValueAt(table_Fornecedor.getSelectedRow(),0).toString());
        campo_nome_Fornecedor.setText(table_Fornecedor.getValueAt(table_Fornecedor.getSelectedRow(),1).toString());
        campo_cnpj_Fornecedor.setText(table_Fornecedor.getValueAt(table_Fornecedor.getSelectedRow(),2).toString());  
        campo_endereco_Fornecedor.setText(table_Fornecedor.getValueAt(table_Fornecedor.getSelectedRow(),3).toString());
    }//GEN-LAST:event_table_FornecedorMouseClicked

    private void bt_Salvar_FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Salvar_FornecedorActionPerformed
        try {
           CadastrarFornecedor();
            campo_nome_Fornecedor.setText("");
        campo_cnpj_Fornecedor.setText("");
        campo_endereco_Fornecedor.setText("");
        campo_cod_Fornecedor.setText("");
            JOptionPane.showMessageDialog(null, "Cadastro realizadinho"); // se funcionar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro falhou: erro "+e); // se der erro
        }
    }//GEN-LAST:event_bt_Salvar_FornecedorActionPerformed

    private void bt_Salvar_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Salvar_ProdutoActionPerformed
          try {
           CadastrarProduto();
             campo_nome_Produto.setText(""); // seta nada para apagar o espaço
       campo_preco_Produto.setText("");
       campo_nome_Fornecedor_Produto.setText("");
       campo_cod_Produto.setText("");
       campo_cod_Fornecedor_Produto.setText("");
            JOptionPane.showMessageDialog(null, "Cadastro realizadinho"); // se funcionar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cadastro falhou: erro "+e); // se der erro
        }
    }//GEN-LAST:event_bt_Salvar_ProdutoActionPerformed

    private void table_Fornecedor_ProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Fornecedor_ProdutoMouseClicked
        campo_cod_Fornecedor_Produto.setText(table_Fornecedor_Produto.getValueAt(table_Fornecedor_Produto.getSelectedRow(),0).toString());
        campo_nome_Fornecedor_Produto.setText(table_Fornecedor_Produto.getValueAt(table_Fornecedor_Produto.getSelectedRow(),1).toString());
    }//GEN-LAST:event_table_Fornecedor_ProdutoMouseClicked

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
       
    }//GEN-LAST:event_sairActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        Tela_Login lg = new Tela_Login();
       lg.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_sairMouseClicked

    private void bt_VendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_VendaActionPerformed
        JOptionPane.showMessageDialog(null, "Em breve na próxima atualização");
    }//GEN-LAST:event_bt_VendaActionPerformed

    private void bt_EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EstoqueActionPerformed
       JOptionPane.showMessageDialog(null, "Em breve na próxima atualização");
    }//GEN-LAST:event_bt_EstoqueActionPerformed

    private void table_Cliente_DonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Cliente_DonoMouseClicked
        campo_cod_dono.setText(table_Cliente_Dono.getValueAt(table_Cliente_Dono.getSelectedRow(), 0).toString());
        campo_nome_Dono.setText(table_Cliente_Dono.getValueAt(table_Cliente_Dono.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_table_Cliente_DonoMouseClicked

    private void bt_salvarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarAnimalActionPerformed
        if(campo_nome_Animal.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Preencha o campo de nome de Animal");
        
        }else if(campo_nome_Dono.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Selecione um dono, aperto n botão de busca");
        }else if(combo_tipo_Animal.getSelectedIndex()== 0){
        JOptionPane.showMessageDialog(null, "Selecione o tipo de animal");
        }else{
        CadastrarAnimal();
        campo_cod_dono.setText("");
        campo_cod_Ani.setText("");
        campo_nome_Animal.setText("");
        campo_nome_Dono.setText("");
        combo_tipo_Animal.setSelectedIndex(0);
        
        
        
        }
    }//GEN-LAST:event_bt_salvarAnimalActionPerformed

    private void table_Funcionário_ServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Funcionário_ServicoMouseClicked
        campo_cod_Func_Servico.setText(table_Funcionário_Servico.getValueAt(table_Funcionário_Servico.getSelectedRow(), 0).toString());
         campo_nome_Funcionario_Servico.setText(table_Funcionário_Servico.getValueAt(table_Funcionário_Servico.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_table_Funcionário_ServicoMouseClicked

    private void table_AnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_AnimalMouseClicked
         campo_cod_Ani.setText(table_Animal.getValueAt(table_Animal.getSelectedRow(), 0).toString());
         campo_nome_Animal_Servico.setText(table_Animal.getValueAt(table_Animal.getSelectedRow(), 1).toString());
         campo_nome_Dono_Servico.setText(table_Animal.getValueAt(table_Animal.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_table_AnimalMouseClicked

    private void bt_Salvar_ServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_Salvar_ServicoActionPerformed
       if(campo_nome_Animal_Servico.getText().isEmpty()){
       table_Animal.requestFocus();
       JOptionPane.showMessageDialog(null, "Escolha o animal");
       
       }else if(campo_nome_Dono_Servico.getText().isEmpty()){
           table_Animal.requestFocus();
       JOptionPane.showMessageDialog(null, "Escolha o animal para cadastrar o dono");
       }else if(campo_nome_Funcionario_Servico.getText().isEmpty()){
           table_Funcionário_Servico.requestFocus();
       JOptionPane.showMessageDialog(null, "Escolha o funcionário");
       }else if(txt_descricao.getText().isEmpty()){
           txt_descricao.requestFocus();
       JOptionPane.showMessageDialog(null, "Informe a descrição do Serviço");
       
       }else{
       CadastrarServico(); // cadastra se tudo
       campo_cod_Ani.setText("");
       campo_cod_dono.setText("");
       campo_cod_Func_Servico.setText("");
       txt_descricao.setText("");
       campo_nome_Animal_Servico.setText("");
       campo_nome_Dono_Servico.setText("");
       campo_nome_Funcionario_Servico.setText("");
               
           
       
       }
    }//GEN-LAST:event_bt_Salvar_ServicoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_painel_Cliente;
    private javax.swing.JLabel back_painel_Fornecedor;
    private javax.swing.JLabel back_painel_Funci;
    private javax.swing.JLabel back_painel_Menu;
    private javax.swing.JLabel back_painel_Produto;
    private javax.swing.JLabel back_painel_Servico;
    private javax.swing.JButton bt_BuscarDono;
    private javax.swing.JButton bt_Estoque;
    private javax.swing.JButton bt_Salvar_Cliente;
    private javax.swing.JButton bt_Salvar_Fornecedor;
    private javax.swing.JButton bt_Salvar_Funcionario;
    private javax.swing.JButton bt_Salvar_Produto;
    private javax.swing.JButton bt_Salvar_Servico;
    private javax.swing.JButton bt_Venda;
    private javax.swing.JButton bt_alterar_Cliente;
    private javax.swing.JButton bt_alterar_Fornecedor;
    private javax.swing.JButton bt_alterar_Funcionario;
    private javax.swing.JButton bt_alterar_Produto;
    private javax.swing.JButton bt_alterar_Servico;
    private javax.swing.JButton bt_frame_close;
    private javax.swing.JButton bt_limpar_Cliente;
    private javax.swing.JButton bt_limpar_Fornecedor;
    private javax.swing.JButton bt_limpar_Funcionario;
    private javax.swing.JButton bt_limpar_Produto;
    private javax.swing.JButton bt_limpar_Servico;
    private javax.swing.JButton bt_salvarAnimal;
    private javax.swing.JTextField campo_cnpj_Fornecedor;
    private javax.swing.JTextField campo_cod_Ani;
    private javax.swing.JTextField campo_cod_Cliente;
    private javax.swing.JTextField campo_cod_Fornecedor;
    private javax.swing.JTextField campo_cod_Fornecedor_Produto;
    private javax.swing.JTextField campo_cod_Func_Servico;
    private javax.swing.JTextField campo_cod_Funcionario;
    private javax.swing.JTextField campo_cod_Produto;
    private javax.swing.JTextField campo_cod_User_servico;
    private javax.swing.JTextField campo_cod_dono;
    private javax.swing.JTextField campo_cpf_Cliente;
    private javax.swing.JTextField campo_cpf_Funcionario;
    private javax.swing.JTextField campo_endereco_Cliente;
    private javax.swing.JTextField campo_endereco_Fornecedor;
    private javax.swing.JTextField campo_endereco_Funcionario;
    private javax.swing.JTextField campo_nome_Animal;
    private javax.swing.JTextField campo_nome_Animal_Servico;
    private javax.swing.JTextField campo_nome_Cliente;
    private javax.swing.JTextField campo_nome_Dono;
    private javax.swing.JTextField campo_nome_Dono_Servico;
    private javax.swing.JTextField campo_nome_Fornecedor;
    private javax.swing.JTextField campo_nome_Fornecedor_Produto;
    private javax.swing.JTextField campo_nome_Funcionario;
    private javax.swing.JTextField campo_nome_Funcionario_Servico;
    private javax.swing.JTextField campo_nome_Produto;
    private javax.swing.JTextField campo_preco_Produto;
    private javax.swing.JTextField campo_telefone_Cliente;
    private javax.swing.JTextField campo_telefone_Funcionario1;
    private javax.swing.JComboBox<String> combo_tipo_Animal;
    private javax.swing.JInternalFrame frame_dono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel label_TabelaFuncionarios;
    private javax.swing.JLabel label_Tabelabixo;
    private javax.swing.JLabel label_Titulo_Cliente;
    private javax.swing.JLabel label_Titulo_Fornecedor;
    private javax.swing.JLabel label_Titulo_Funcionario;
    private javax.swing.JLabel label_Titulo_Produto;
    private javax.swing.JLabel label_Titulo_Serviço;
    private javax.swing.JLabel label_cachorroMexicano;
    private javax.swing.JLabel label_cachorroMexicano1;
    private javax.swing.JLabel label_cnpj_Aviso;
    private javax.swing.JLabel label_cpf_Aviso;
    private javax.swing.JLabel label_cpf_Aviso_Cliente;
    private javax.swing.JLabel label_cpf_Cliente;
    private javax.swing.JLabel label_cpf_Cliente1;
    private javax.swing.JLabel label_cpf_FunC;
    private javax.swing.JLabel label_descricao_Servico;
    private javax.swing.JLabel label_endereco_Cliente;
    private javax.swing.JLabel label_endereco_Fornecedor;
    private javax.swing.JLabel label_nome_Animal;
    private javax.swing.JLabel label_nome_Animal_Servico1;
    private javax.swing.JLabel label_nome_Cliente;
    private javax.swing.JLabel label_nome_Dono;
    private javax.swing.JLabel label_nome_Dono_Servico;
    private javax.swing.JLabel label_nome_Fornecedor;
    private javax.swing.JLabel label_nome_Fornecedor_Produto;
    private javax.swing.JLabel label_nome_Func;
    private javax.swing.JLabel label_nome_Funcionario_Servico1;
    private javax.swing.JLabel label_nome_Produto;
    private javax.swing.JLabel label_preco_Produto;
    private javax.swing.JLabel label_telefone_Cliente;
    private javax.swing.JLabel label_telefone_FunC;
    private javax.swing.JLabel label_telefone_FunC1;
    private javax.swing.JLabel label_tipo_Animal;
    private javax.swing.JLabel label_titulo_Menu;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menu_Controle;
    private javax.swing.JMenu menu_VoltarMenu;
    private javax.swing.JMenuItem menuiten_Cliente;
    private javax.swing.JMenuItem menuiten_Fornecedor;
    private javax.swing.JMenuItem menuiten_Funcionário;
    private javax.swing.JMenuItem menuiten_Produto;
    private javax.swing.JMenuItem menuiten_Servico;
    private javax.swing.JPanel painel_Cliente;
    private javax.swing.JPanel painel_Fornecedor;
    private javax.swing.JPanel painel_Funcionário;
    private javax.swing.JPanel painel_Menu;
    private javax.swing.JPanel painel_Produto;
    private javax.swing.JPanel painel_Servico;
    private javax.swing.JMenu sair;
    private javax.swing.JTable table_Animal;
    private javax.swing.JTable table_Cliente;
    private javax.swing.JTable table_Cliente_Dono;
    private javax.swing.JTable table_Fornecedor;
    private javax.swing.JTable table_Fornecedor_Produto;
    private javax.swing.JTable table_Funcionário;
    private javax.swing.JTable table_Funcionário_Servico;
    private javax.swing.JTable table_Produto;
    private javax.swing.JTextArea txt_descricao;
    // End of variables declaration//GEN-END:variables
}
