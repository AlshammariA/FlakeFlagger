@Test(expected=WroRuntimeException.class) public void testWithoutLastValidThrowsException(){
  Assert.assertNotNull(xmlModelFactory.create());
}
