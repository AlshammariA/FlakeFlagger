@Test(expected=NullPointerException.class) public void cannotAcceptNullOriginalName() throws Exception {
  namingStrategy.rename(null,WroUtil.EMPTY_STREAM);
}
