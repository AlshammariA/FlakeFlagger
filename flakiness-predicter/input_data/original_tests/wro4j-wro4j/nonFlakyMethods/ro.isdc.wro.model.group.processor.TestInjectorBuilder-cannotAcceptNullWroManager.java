@Test(expected=NullPointerException.class) public void cannotAcceptNullWroManager(){
  new InjectorBuilder(null);
}
