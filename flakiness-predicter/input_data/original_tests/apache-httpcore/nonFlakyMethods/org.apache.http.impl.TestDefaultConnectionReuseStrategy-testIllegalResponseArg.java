@Test(expected=IllegalArgumentException.class) public void testIllegalResponseArg() throws Exception {
  reuseStrategy.keepAlive(null,this.context);
}
