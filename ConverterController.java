import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class ConverterController {
	
	private final ConverterModelClass converter_model;
	private final ConverterView converter_view;
	
	// These are redundant variables to report the internal functioning of the controller
	public double amount_reporter;
	public int choice_reporter;
	public double converter_amount_reporter;
	
	public ConverterController(ConverterView c_view, ConverterModelClass c_model) {
		this.converter_model = c_model;
		this.converter_view = c_view;
		ConverterActionEvents cae = new ConverterActionEvents();
		ConverterQuitAction cqa = new ConverterQuitAction();
		RadioListeners ra = new RadioListeners();
		converter_view.addEventActionListeners(cae);
		converter_view.addQuitEventListener(cqa);
		converter_view.addRadioListeners(ra);
		converter_view.addClearEventActionListener(new ClearActionEvents());
	} 
	
	public class ClearActionEvents implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			converter_view.clearAllFields();
			
		}
		
	}
	
	public class ConverterQuitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);			
		}
		
	}
	
	
	class ConverterActionEvents implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			double amount =0.0;
			int choice =0;
			double converted_amount=0.0;
			
	
			try{
		
				amount = converter_view.get_amount();
				choice = converter_view.get_choice();
				amount_reporter = amount;
				choice_reporter=choice;
		
				if(choice==0)
					{
					converter_view.showNoChoiceError();
					throw new IllegalArgumentException("Illegal Option");
					}
				
				else if(amount<=0.0 || converter_view.checkEmpty())
				{
					converter_view.showSomeError();
					throw new IllegalArgumentException("Illegal Value(s)");
				}
				
				else if (amount >10000)
				{
					converter_view.showBoundsError();
					throw new IllegalArgumentException("Out of Bounds");
				}
				else{
		
				converted_amount = converter_model.convert_currency(amount, choice);
				converter_view.setConvertedValue(converted_amount);
				converter_amount_reporter = converted_amount;
				}
				}
			catch (IllegalArgumentException e1)
				{
				converter_view.showBoundsError();
				System.out.println("Error");
				
				
				}}}

			
public class RadioListeners implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
	if (converter_view.getCurrentCurrency()==1)
	{
		converter_view.setEq("Brazilian Real");
		converter_view.setChoice(1);
	}
	else if (converter_view.getCurrentCurrency()==2)
	{
		converter_view.setEq("Canadian Dollar");
		converter_view.setChoice(2);
	}
	else if (converter_view.getCurrentCurrency()==3)
	{
		converter_view.setEq("Euros");
		converter_view.setChoice(3);
	}
	else if (converter_view.getCurrentCurrency()==4)
	{
		converter_view.setEq("Japanese Yen");
		converter_view.setChoice(4);
	}
		
	}
	
}

public double report_amount()
{
	return this.amount_reporter;
}

public int return_choice()
{
	return this.choice_reporter;
}

public double report_converted_amount()
{
	return this.converter_amount_reporter;
}
	

}
