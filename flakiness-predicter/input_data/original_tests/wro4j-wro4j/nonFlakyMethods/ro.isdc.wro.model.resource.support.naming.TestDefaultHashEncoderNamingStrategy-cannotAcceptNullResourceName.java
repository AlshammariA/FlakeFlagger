@Test(expected=NullPointerException.class) public void cannotAcceptNullResourceName() throws Exception {
  namingStrategy.rename(null,WroUtil.EMPTY_STREAM);
}
