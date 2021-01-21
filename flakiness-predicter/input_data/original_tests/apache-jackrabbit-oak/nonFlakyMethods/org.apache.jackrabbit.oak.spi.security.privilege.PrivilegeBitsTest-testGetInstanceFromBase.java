@Test public void testGetInstanceFromBase(){
  PrivilegeBits pb=PrivilegeBits.getInstance(READ_NODES_PRIVILEGE_BITS);
  pb.add(PrivilegeBits.BUILT_IN.get(PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
  pb.add(PrivilegeBits.BUILT_IN.get(PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT));
  PrivilegeBits pb2=PrivilegeBits.getInstance(READ_NODES_PRIVILEGE_BITS,PrivilegeBits.BUILT_IN.get(PrivilegeConstants.JCR_READ_ACCESS_CONTROL),PrivilegeBits.BUILT_IN.get(PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT));
  assertEquivalent(pb,pb2);
}
