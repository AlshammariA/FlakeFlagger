@Test(expected=NullPointerException.class) public void cannotRegisterNullCallback(){
  final WroManager manager=new BaseWroManagerFactory().create();
  manager.registerCallback(null);
}
