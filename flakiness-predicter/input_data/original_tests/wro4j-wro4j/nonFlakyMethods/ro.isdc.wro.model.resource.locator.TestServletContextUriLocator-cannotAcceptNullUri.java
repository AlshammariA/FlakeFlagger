@Test(expected=NullPointerException.class) public void cannotAcceptNullUri() throws Exception {
  victim.locate(null);
}
