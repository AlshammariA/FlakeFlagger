@Test public void testAllAggregation() throws Exception {
  PrivilegeBits all=bitsProvider.getBits(JCR_ALL);
  PrivilegeManager pMgr=getSecurityProvider().getConfiguration(PrivilegeConfiguration.class).getPrivilegeManager(root,NamePathMapper.DEFAULT);
  Iterable<Privilege> declaredAggr=Arrays.asList(pMgr.getPrivilege(JCR_ALL).getDeclaredAggregatePrivileges());
  String[] allAggregates=Iterables.toArray(Iterables.transform(declaredAggr,new Function<Privilege,String>(){
    @Override public String apply(    @Nullable Privilege privilege){
      return checkNotNull(privilege).getName();
    }
  }
),String.class);
  PrivilegeBits all2=bitsProvider.getBits(allAggregates);
  assertEquals(all,all2);
  assertEquals(Collections.singleton(JCR_ALL),bitsProvider.getPrivilegeNames(all2));
  PrivilegeBits bits=PrivilegeBits.getInstance();
  for (  String name : allAggregates) {
    bits.add(bitsProvider.getBits(name));
  }
  assertEquals(all,bits.unmodifiable());
}
