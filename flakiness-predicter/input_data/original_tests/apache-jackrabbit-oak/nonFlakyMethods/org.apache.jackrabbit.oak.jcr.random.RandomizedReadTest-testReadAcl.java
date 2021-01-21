@Test public void testReadAcl() throws Exception {
  for (int j=0; j < 1; j++) {
    Random r=new Random(j);
    int operations=1000;
    int depthToApply;
    int index;
    boolean allow;
    int principalIndex;
    for (int i=0; i < operations; i++) {
      allow=r.nextBoolean();
      depthToApply=r.nextInt(depth);
      principalIndex=r.nextInt(ids.length);
      if (depthToApply > 0) {
        index=r.nextInt(depthToApply + 1);
        String path=getPath(depthToApply,index);
        setupPermissions(principalIndex,path,allow,PrivilegeConstants.JCR_READ);
        check();
      }
    }
  }
}
