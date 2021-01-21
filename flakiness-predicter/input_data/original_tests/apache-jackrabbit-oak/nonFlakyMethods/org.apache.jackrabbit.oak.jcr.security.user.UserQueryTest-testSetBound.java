@Test public void testSetBound() throws RepositoryException {
  List<User> sortedUsers=new ArrayList<User>(users);
  sortedUsers.removeAll(systemDefined);
  Comparator<? super User> comp=new Comparator<User>(){
    public int compare(    User user1,    User user2){
      try {
        Value[] weight1=user1.getProperty("profile/weight");
        assertNotNull(weight1);
        assertEquals(1,weight1.length);
        Value[] weight2=user2.getProperty("profile/weight");
        assertNotNull(weight2);
        assertEquals(1,weight2.length);
        return weight1[0].getDouble() < weight2[0].getDouble() ? -1 : 1;
      }
 catch (      RepositoryException e) {
        fail(e.getMessage());
        return 0;
      }
    }
  }
;
  Collections.sort(sortedUsers,comp);
  long[] counts={4,0,100000};
  for (  final long count : counts) {
    Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        builder.setCondition(builder.eq("profile/@cute",vf.createValue(true)));
        builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING,true);
        builder.setLimit(vf.createValue(1000.0),count);
      }
    }
);
    Iterator<User> expected=Iterators.filter(sortedUsers.iterator(),new Predicate<User>(){
      public boolean apply(      User user){
        try {
          Value[] cute=user.getProperty("profile/cute");
          Value[] weight=user.getProperty("profile/weight");
          return cute != null && cute.length == 1 && cute[0].getBoolean() && weight != null && weight.length == 1 && weight[0].getDouble() > 1000.0;
        }
 catch (        RepositoryException e) {
          fail(e.getMessage());
        }
        return false;
      }
    }
);
    assertSame(expected,result,count);
    assertFalse(result.hasNext());
  }
}
