@Test public void testHashCode(){
  assertTrue(everyone.hashCode() == EveryonePrincipal.getInstance().hashCode());
}
