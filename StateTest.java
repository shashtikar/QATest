import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class StateTest {
	public static ConverterModelClass model;
	public static ConverterView view;
	public static ConverterController controller;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	
	@Test()
	public void test1()
	{
		model = new ConverterModelClass();
		assertEquals(-17.00,model.convert_currency(-20, 1),0);
	}
	
	@Test
	public void test2()
	{
		model = new ConverterModelClass();
		assertEquals(1040.00, model.convert_currency(1000, 2),2);
	}
	
	@Test
	public void test3()
	{
		model= new ConverterModelClass();
		assertEquals(2320.00, model.convert_currency(1000, 1),0);
	}
	
	@Test
	public void test4()
	{
		model= new ConverterModelClass();
		assertEquals(99870.00, model.convert_currency(1000, 3),2);
	}
	
	@Test
	public void test5()
	{
		model= new ConverterModelClass();
		assertEquals(740.00, model.convert_currency(1000, 4),2);
	}
	
	@Test
	public void test6()
	{
		model= new ConverterModelClass();
		assertEquals(-17.00, model.convert_currency(1000, -1),2);
	}
	
	@Test
	public void test7()
	{
		view = new ConverterView();
		view.click_clear();
		assertEquals(true, view.checkEmpty());
	}
	
	@Test
	public void test8()
	{
		view = new ConverterView();
		view.select_brazil();
		assertEquals(1, view.get_choice());
	}
	
	@Test
	public void test9()
	{
		view = new ConverterView();
		view.select_candol();
		assertEquals(2, view.get_choice());
	}
	
	@Test
	public void test10()
	{
		view = new ConverterView();
		view.select_jap_yen();
		assertEquals(4, view.get_choice());
	}
	
	@Test
	public void test11()
	{
		view = new ConverterView();
		view.select_euros();
		assertEquals(3, view.get_choice());
	}
	
	@Test
	public void test12()
	{
		view = new ConverterView();
		view.click_clear();
		view.select_brazil();
		view.click_submit();
		assertEquals(0.00, view.get_amount(),2);
	}
	
	@Test
	public void test13()
	{
		view = new ConverterView();
		view.click_clear();
		assertEquals(0, view.get_choice());
	}
	
	@Test
	public void test14()
	{
		view = new ConverterView();
		view.click_clear();
		view.select_brazil();
		
		assertEquals("Brazilian Real", view.getEquivalent());
	}
	
	@Test
	public void test15()
	{
		view = new ConverterView();
		view.click_clear();
		view.select_candol();
		
		assertEquals("Canadian Dollar", view.getEquivalent());
	}
	
	@Test
	public void test16()
	{
		view = new ConverterView();
		view.click_clear();
		view.select_jap_yen();
		
		assertEquals("Japanese Yen", view.getEquivalent());
	}
	
	@Test
	public void test17()
	{
		view = new ConverterView();
		view.click_clear();
		view.select_euros();
		
		assertEquals("Euros", view.getEquivalent());
	}
	
	@Test
	public void test18()
	{
		view = new ConverterView();
		view.click_clear();
		view.setAmount(1000.00);
		
		assertEquals(false, view.checkEmpty());
		assertEquals(1000,view.get_amount(),2);
	}
	
	@Test
	public void test19()
	{
		view = new ConverterView();
		controller = new ConverterController(view, model);
		view.click_clear();
		view.select_brazil();
		view.setAmount(1000.00);
		view.click_submit();
		
		
		assertEquals(1000, controller.report_amount(),2);
		//assertEquals(2320, controller.report_converted_amount(),2);
		//assertEquals(1, controller.return_choice());
	}
	
	@Test
	public void test20()
	{
		view = new ConverterView();
		controller = new ConverterController(view, model);
		view.click_clear();
		view.select_brazil();
		view.setAmount(1000.00);
		view.click_submit();
		
		
		assertEquals(2320, controller.report_converted_amount(),2);
	}
	
	@Test
	public void test21()
	{
		view = new ConverterView();
		controller = new ConverterController(view, model);
		view.click_clear();
		view.select_brazil();
		view.setAmount(1000.00);
		view.click_submit();		
		assertEquals(1, controller.return_choice());
	}
	
	@Test
	public void test22()
	{
		view = new ConverterView();
		controller = new ConverterController(view, model);
		view.click_clear();
		view.select_brazil();
		view.setAmount(1000000.00);
		view.click_submit();		
	thrown.expect(IllegalArgumentException.class);
	throw new IllegalArgumentException();
	}
	
	@Test
	public void test23()
	{
		view = new ConverterView();
		controller = new ConverterController(view, model);
		view.click_clear();
		view.select_brazil();
		view.setAmount(-100.00);
		view.click_submit();			
	thrown.expect(IllegalArgumentException.class);
	throw new IllegalArgumentException();
	}
	
	@Test
	public void test24()
	{
		view = new ConverterView();
		controller = new ConverterController(view, model);
		view.click_clear();
		
		view.setAmount(1000.00);
		view.click_submit();		
		
	thrown.expect(IllegalArgumentException.class);
	throw new IllegalArgumentException();
	}
	
	@Test
	public void test25()
	{
		view = new ConverterView();
		controller = new ConverterController(view, model);
		view.click_clear();
		view.click_submit();		
		
	thrown.expect(IllegalArgumentException.class);
	throw new IllegalArgumentException();
	}
	
	
	
	
	
	
	
	

}
