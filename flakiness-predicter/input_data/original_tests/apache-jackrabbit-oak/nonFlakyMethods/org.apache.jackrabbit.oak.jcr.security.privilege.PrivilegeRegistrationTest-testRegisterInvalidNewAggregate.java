@Test public void testRegisterInvalidNewAggregate() throws RepositoryException {
  Map<String,String[]> newAggregates=new LinkedHashMap<String,String[]>();
  newAggregates.put("jcrReadAggregate",getAggregateNames(PrivilegeConstants.JCR_READ));
  newAggregates.put("newAggregate2",getAggregateNames(PrivilegeConstants.JCR_READ,"unknownPrivilege"));
  newAggregates.put("newAggregate3",getAggregateNames("unknownPrivilege"));
  newAggregates.put("newAggregate4",getAggregateNames("newAggregate"));
  newAggregates.put("repWriteAggregate",getAggregateNames(PrivilegeConstants.JCR_MODIFY_PROPERTIES,PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT,PrivilegeConstants.JCR_REMOVE_CHILD_NODES,PrivilegeConstants.JCR_REMOVE_NODE));
  newAggregates.put("newAggregate5",getAggregateNames(PrivilegeConstants.JCR_READ,"unknownPrivilege"));
  for (  String name : newAggregates.keySet()) {
    try {
      privilegeManager.registerPrivilege(name,true,newAggregates.get(name));
      fail("New aggregate " + name + " referring to unknown Privilege  -> Exception expected");
    }
 catch (    RepositoryException e) {
    }
  }
}
