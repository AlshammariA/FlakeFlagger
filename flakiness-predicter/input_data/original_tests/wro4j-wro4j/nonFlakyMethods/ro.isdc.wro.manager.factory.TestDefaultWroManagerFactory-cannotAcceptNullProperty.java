@Test(expected=NullPointerException.class) public void cannotAcceptNullProperty(){
  final Properties props=null;
  new DefaultWroManagerFactory(props);
}
