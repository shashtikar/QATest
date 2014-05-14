public class ConverterModelClass {

	//private final ConverterView c;
	private static final double brazil_value = 2.32, can_value = 1.04, jap_value=99.87, eur_value=0.74; 
	
	ConverterModelClass()
	{
	//this.c = view;	
	
	}
	
	public double convert_currency(double amount, int choice)
	{
		double sum = 0;
		if (amount<=0)
		{
			sum= -17.0;
			//throw new IllegalArgumentException("The entered amount is invalid");
		}
		
		else if (choice==1)
		{
			sum=amount*brazil_value;
		}
		else if (choice==2)
		{
			sum=amount*can_value;
		}
		else if (choice ==3)
		{
			sum=amount*jap_value;
		}
		else if (choice==4)
		{
			sum=amount*eur_value;
		}
		else {
			//throw new IllegalArgumentException("Illegal Choice");
			sum=-17.00;
				}
		return sum;
	
	}
	
}
