@Test(expected=NullPointerException.class) public void cannotAcceptNullModel(){
  new WroModelInspector(null);
}
