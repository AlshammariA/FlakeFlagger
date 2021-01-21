@Test public void testObjectMethods() throws Exception {
  final Authorizable user=getTestUser(superuser);
  Authorizable user2=getTestUser(superuser);
  assertEquals(user,user2);
  assertEquals(user.hashCode(),user2.hashCode());
  Set<Authorizable> s=new HashSet<Authorizable>();
  s.add(user);
  assertFalse(s.add(user2));
  Authorizable user3=new Authorizable(){
    public String getID() throws RepositoryException {
      return user.getID();
    }
    public boolean isGroup(){
      return user.isGroup();
    }
    public Principal getPrincipal() throws RepositoryException {
      return user.getPrincipal();
    }
    public Iterator<Group> declaredMemberOf() throws RepositoryException {
      return user.declaredMemberOf();
    }
    public Iterator<Group> memberOf() throws RepositoryException {
      return user.memberOf();
    }
    public void remove() throws RepositoryException {
      user.remove();
    }
    public Iterator<String> getPropertyNames() throws RepositoryException {
      return user.getPropertyNames();
    }
    public Iterator<String> getPropertyNames(    String relPath) throws RepositoryException {
      return user.getPropertyNames(relPath);
    }
    public boolean hasProperty(    String name) throws RepositoryException {
      return user.hasProperty(name);
    }
    public void setProperty(    String name,    Value value) throws RepositoryException {
      user.setProperty(name,value);
    }
    public void setProperty(    String name,    Value[] values) throws RepositoryException {
      user.setProperty(name,values);
    }
    public Value[] getProperty(    String name) throws RepositoryException {
      return user.getProperty(name);
    }
    public boolean removeProperty(    String name) throws RepositoryException {
      return user.removeProperty(name);
    }
    public String getPath() throws RepositoryException {
      return user.getPath();
    }
  }
;
  assertFalse(user.equals(user3));
  assertTrue(s.add(user3));
}
