@Test public void testFindEveryoneHint(){
  assertNotNull(principalProvider.getPrincipal(EveryonePrincipal.NAME));
  List<String> nameHints=new ArrayList<String>();
  nameHints.add("everyone");
  nameHints.add("every");
  nameHints.add("one");
  nameHints.add("very");
  assertResult(principalProvider,nameHints,EveryonePrincipal.NAME,PrincipalManager.SEARCH_TYPE_ALL,true);
  assertResult(principalProvider,nameHints,EveryonePrincipal.NAME,PrincipalManager.SEARCH_TYPE_GROUP,true);
  assertResult(principalProvider,nameHints,EveryonePrincipal.NAME,PrincipalManager.SEARCH_TYPE_NOT_GROUP,false);
}
