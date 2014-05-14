import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.text.AbstractDocument.BranchElement;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ConverterView extends JPanel implements ItemListener {
	
	private double amount_convert;
	private int choice;
	
	private ButtonGroup currGroup;
	
	
	private JTextField amount;
	private JTextField eq;
	private JTextField converted_amount;
	
	private JButton submit;
	private JButton clear;
	private JButton quit;
	
	
	private JRadioButton br_real = new JRadioButton("Brazilian Real");
	private JRadioButton can_dol = new JRadioButton("Canadian Dollars");
	private JRadioButton euros = new JRadioButton("Euros");
	private JRadioButton jap_yen = new JRadioButton("Japanese yen");
	
	private JTextField title;
	private JTextField equiv;
	private JTextField amount_text;
	
	public ConverterView()
	{
		
		
		this.amount_convert=0.0;
		this.choice=0;
		
		title = new JTextField("Currency Converter");
		title.setEditable(false);
		
		equiv = new JTextField("Equivalent in: ");
		equiv.setEditable(false);
		
		amount_text = new JTextField("Enter the Amount: ");
		amount_text.setEditable(false);
		
		submit = new JButton("Submit");
		
		clear= new JButton("Clear");
		quit = new JButton("Quit");
		
		currGroup = new ButtonGroup();
		
		amount = new JTextField("",10);
		eq= new JTextField("",15);
		
		converted_amount = new JTextField("",10);
		converted_amount.setEditable(true);
        
		
		currGroup.add(br_real);
		currGroup.add(can_dol);
		currGroup.add(euros);
		currGroup.add(jap_yen);
		
		
		title.setBounds(20, 20, 200, 30);
		amount_text.setBounds(20, 70, 100, 30);
		amount.setBounds(150,70, 100, 30);
		
		JPanel content = new JPanel();
		
	
		add(title);
		add (amount_text);
		add(amount);
		add(converted_amount);
		add(equiv);
		add(eq);
		content.add(br_real);
		content.add(can_dol);
		content.add(euros);
		content.add(jap_yen);
		add(content);
		add(submit);
		add(clear);
		add(quit);
		
		ConverterModelClass model = new ConverterModelClass();
		ConverterController controller = new ConverterController(this, model);	

	}

	
	public void addEventActionListeners(ActionListener actionListener)
	{
		submit.addActionListener(actionListener);
		
	}
	
	public void addClearEventActionListener(ActionListener clearActionListener)
	{
		clear.addActionListener(clearActionListener);
	}
	
	public void addQuitEventListener(ActionListener quitActionListener)
	{
		quit.addActionListener(quitActionListener);
	}
	
	public void addEventItemListeners()
	{
		br_real.addItemListener(this);
		can_dol.addItemListener(this);
		euros.addItemListener(this);
		jap_yen.addItemListener(this);
	}

	
	public void addRadioListeners(ActionListener al)
	{
		br_real.addActionListener(al);
		can_dol.addActionListener(al);
		euros.addActionListener(al);
		jap_yen.addActionListener(al);
	}


	public void itemStateChanged1(ItemEvent e) {
		
	}
	
	public double get_amount()
	{
		if(amount.getText().length()!=0){
		//amount_convert = (double)Integer.parseInt(this.amount.getText().toString().trim());
		amount_convert = Double.parseDouble(this.amount.getText().toString().trim());
		}
		else{
			amount_convert=0;
		}
		return amount_convert;
	}
	
	public int get_choice()
	{
		return choice;
		
	}

	
	public void setConvertedValue(double value)
	{
		this.converted_amount.setText(String.valueOf((double)value).trim());
	}
	
	public void setAmount(double val)
	{
		this.amount.setText(String.valueOf((double)val).trim());
	}
	
	public void clearAllFields()
	{
		this.amount.setText("");
		this.converted_amount.setText("");
		this.eq.setText("");
		this.converted_amount.setText("");
		this.choice=0;
		this.amount_convert=0.0;
		this.currGroup.clearSelection();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==br_real)
		{
			eq.setText("Brazilian Real");
			this.choice=1;
			
		}
		else if( e.getSource()==can_dol)
		{
			eq.setText("Canadian Dollars");
			this.choice=2;
		}
		
		else if (e.getSource()==jap_yen)
		{
			eq.setText("Japanese Yen");
			this.choice=3;
			
		}
		
		else if (e.getSource()==euros)
		{
			eq.setText("Euros");
			this.choice=4;
		}
		
	}
	
	private static void createAndShowGUI() {

        
		JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        ConverterView newContentPane = new ConverterView();
        
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
       
        
    }

//    public void clearAll()
//    {
//    	amount.setText("");
//    	eq.setText("");
//    	
//    }
    
    public int getCurrentCurrency()
    {
    	if (br_real.isSelected())
    	{
    		return 1;
    		
    	}
    	else if (can_dol.isSelected())
    	{
    		return 2;
    	}
    	else if (euros.isSelected())
    	{
    		return 3;
    	}
    	else
    	{
    		return 4;
    	}
    }
    
    public void setEq(String equivalent_currency)
    {
    	eq.setText(equivalent_currency);
    }
    
    public void setChoice(int x)
    {
    	this.choice=x;
    }
    
    public void showSomeError()
	{
		JOptionPane.showMessageDialog(this, "Error: Amount field must be non-empty with value greater than zero.");
	}
    
    public void showBoundsError()
	{
		JOptionPane.showMessageDialog(this, "Error: Amount should be less than 10,000");
		this.converted_amount.setText("Out of Bounds");
	}
    
    public void showNoChoiceError()
    {
    	JOptionPane.showMessageDialog(this, "Error: Some currency must be chosen");
    }
    
    public boolean checkEmpty(){
    	if (amount.getText().length()==0)
    	{
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void select_brazil()
    {
    	br_real.doClick();
    }

    public void select_candol()
    {
    	can_dol.doClick();
    }
    
    public void select_jap_yen()
    {
    	jap_yen.doClick();
    }
    public void select_euros()
    {
    	euros.doClick();
    }
    
    public void click_clear()
    {
    	clear.doClick();
    }
    
    public void click_submit()
    {
    	submit.doClick();
    }
    
    public String getEquivalent()
    {
    	return eq.getText();
    }
    
    
}
