@Test public void testAddEntry() throws RepositoryException {
  Principal unknown=new Principal(){
    @Override public String getName(){
      return "anotherUnknown";
    }
  }
;
  AccessControlUtils.addAccessControlEntry(adminSession,target.getPath(),unknown,new String[]{Privilege.JCR_READ},true);
}
