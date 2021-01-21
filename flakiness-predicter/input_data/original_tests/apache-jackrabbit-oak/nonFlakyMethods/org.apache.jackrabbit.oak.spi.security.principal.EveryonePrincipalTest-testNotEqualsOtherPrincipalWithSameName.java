@Test public void testNotEqualsOtherPrincipalWithSameName(){
  Principal someotherEveryone=new Principal(){
    public String getName(){
      return EveryonePrincipal.NAME;
    }
  }
;
  assertFalse(everyone.equals(someotherEveryone));
}
