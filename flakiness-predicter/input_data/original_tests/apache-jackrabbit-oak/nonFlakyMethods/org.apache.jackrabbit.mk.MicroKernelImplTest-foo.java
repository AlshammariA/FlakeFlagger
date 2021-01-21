@Test(expected=Throwable.class) public void foo(){
  mk.commit("","+\"/x\":{}",null,null);
  mk.commit("","+\"/x/\":{}",null,null);
}
