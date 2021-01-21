@Test public void testWithException(){
  Status s0=new ErrorStatus("test0",this);
  Status s1=new InfoStatus("test1",this,new Exception("testEx"));
  Status s11=new InfoStatus("test11",this);
  Status s12=new InfoStatus("test12",this);
  s1.add(s11);
  s1.add(s12);
  Status s2=new InfoStatus("test2",this);
  Status s21=new InfoStatus("test21",this);
  Status s211=new WarnStatus("test211",this);
  Status s22=new InfoStatus("test22",this);
  s2.add(s21);
  s2.add(s22);
  s21.add(s211);
  Context context=new ContextBase();
  context.getStatusManager().add(s0);
  context.getStatusManager().add(s1);
  context.getStatusManager().add(s2);
  StatusPrinter.print(context);
  String result=outputStream.toString();
  assertTrue(result.contains("|-ERROR in " + this.getClass().getName()));
  assertTrue(result.contains("+ INFO in " + this.getClass().getName()));
  assertTrue(result.contains("ch.qos.logback.core.util.StatusPrinterTest.testWithException"));
}
