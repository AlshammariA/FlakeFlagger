@Test public void testMultiValuedToSingle() throws Exception {
  UserManager uMgr=getUserManager(superuser);
  try {
    Value v=superuser.getValueFactory().createValue("anyValue");
    Value[] vs=new Value[]{v,v};
    user.setProperty("someProp",vs);
    if (!uMgr.isAutoSave()) {
      superuser.save();
    }
    user.setProperty("someProp",v);
    if (!uMgr.isAutoSave()) {
      superuser.save();
    }
  }
  finally {
    if (user.removeProperty("someProp") && !uMgr.isAutoSave()) {
      superuser.save();
    }
  }
}
