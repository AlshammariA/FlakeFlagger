@Test(expected=NullPointerException.class) public void cannotAcceptNullUri() throws IOException {
  victim.locate(null);
}
