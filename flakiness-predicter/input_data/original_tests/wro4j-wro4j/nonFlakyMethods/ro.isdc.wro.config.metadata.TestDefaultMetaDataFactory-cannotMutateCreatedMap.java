@Test(expected=UnsupportedOperationException.class) public void cannotMutateCreatedMap(){
  victim.create().put("key","value");
}
