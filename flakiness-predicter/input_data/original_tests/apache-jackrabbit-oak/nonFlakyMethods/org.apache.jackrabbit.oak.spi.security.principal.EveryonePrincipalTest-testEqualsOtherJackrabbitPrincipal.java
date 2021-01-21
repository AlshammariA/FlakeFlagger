@Test public void testEqualsOtherJackrabbitPrincipal(){
  Principal someotherEveryone=new OtherEveryone();
  assertFalse(everyone.equals(someotherEveryone));
}
