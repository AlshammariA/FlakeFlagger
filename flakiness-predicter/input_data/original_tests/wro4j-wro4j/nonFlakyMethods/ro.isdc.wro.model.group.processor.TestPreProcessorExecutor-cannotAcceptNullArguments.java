@Test(expected=NullPointerException.class) public void cannotAcceptNullArguments() throws Exception {
  victim.processAndMerge(null,true);
}
