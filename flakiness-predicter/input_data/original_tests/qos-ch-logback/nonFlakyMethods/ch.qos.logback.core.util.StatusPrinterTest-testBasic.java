@Test public void testBasic(){
  Context context=new ContextBase();
  context.getStatusManager().add(new InfoStatus("test",this));
  StatusPrinter.print(context);
  String result=outputStream.toString();
  assertTrue(result.contains("|-INFO in " + this.getClass().getName()));
}
