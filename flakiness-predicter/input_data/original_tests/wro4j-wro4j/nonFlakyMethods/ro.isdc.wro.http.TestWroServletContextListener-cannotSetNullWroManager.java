@Test(expected=NullPointerException.class) public void cannotSetNullWroManager(){
  victim.setManagerFactory(null);
}
