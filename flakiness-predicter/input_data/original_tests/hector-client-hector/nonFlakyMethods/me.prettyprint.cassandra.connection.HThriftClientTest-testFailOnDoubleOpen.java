@Test(expected=IllegalStateException.class) public void testFailOnDoubleOpen(){
  hThriftClient.open().open();
}
