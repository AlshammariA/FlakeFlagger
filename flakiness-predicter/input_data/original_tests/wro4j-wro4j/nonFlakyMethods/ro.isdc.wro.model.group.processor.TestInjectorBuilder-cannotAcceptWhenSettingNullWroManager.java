@Test(expected=NullPointerException.class) public void cannotAcceptWhenSettingNullWroManager(){
  new InjectorBuilder(null);
}
