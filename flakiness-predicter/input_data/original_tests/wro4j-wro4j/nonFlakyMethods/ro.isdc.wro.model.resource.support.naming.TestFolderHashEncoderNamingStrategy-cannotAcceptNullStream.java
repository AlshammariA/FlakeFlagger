@Test(expected=NullPointerException.class) public void cannotAcceptNullStream() throws Exception {
  namingStrategy.rename("fileName.js",null);
}
