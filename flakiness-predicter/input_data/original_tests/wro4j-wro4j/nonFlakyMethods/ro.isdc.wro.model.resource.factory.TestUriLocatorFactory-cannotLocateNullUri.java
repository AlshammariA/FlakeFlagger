@Test(expected=WroRuntimeException.class) public void cannotLocateNullUri() throws Exception {
  factory.locate(null);
}
