function(f) {
  for (var i=0;i<this.length;i++) {
    if (f(this[i]))return true;
  }
  return false;
}
