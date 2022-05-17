/*
 * Copyright Harshad RJ ( http://lavadip.com )
 * Distributed with no warranties, explicit or implied.  
 */
package com.lavadip.searchertest;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Searcher extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
  }
  
  public void clickSkyMapSearch(View v) {
    
    final Intent skyIntent = new Intent(Intent.ACTION_SEARCH);
    skyIntent.setPackage("com.google.android.stardroid");
    skyIntent.putExtra(SearchManager.QUERY, "Bootes");
    
    safeLaunchActivity(skyIntent, "Google SkyMap");
  }
  
  public void clickSkEyeSearch(View v) {
    safeLaunchSkEye("astro_object//constellation/bootes");
  }
  
  public void clickAldebaranSkEyeSearch(View v) {
    safeLaunchSkEye("astro_object//star/Aldebaran");
  }
  
  public void clickMessierSkEyeSearch(View v) {
    safeLaunchSkEye("astro_object//messier/m31");
  }
  
  public void clickNGCSkEyeSearch(View v) {
    safeLaunchSkEye("astro_object//ngc/ngc104");
  }
  
  public void clickJupiterSkEyeSearch(View v) {
    safeLaunchSkEye("astro_object//solarsys/jupiter");
  }
  
  // The following two helper functions will help launch SkEye safely
  private void safeLaunchSkEye(String objPath) {
    final Intent skEyeIntent = new Intent(Intent.ACTION_SEARCH);
    final Uri targetUri = new Uri.Builder().path(objPath).build();
    skEyeIntent.setDataAndType(targetUri, "text/astro_object");
    
    safeLaunchActivity(skEyeIntent, "SkEye v1.1 or higher");
  }
  
  private void safeLaunchActivity (Intent i, String hint) {
    if (i.resolveActivity(getPackageManager())!= null) {
      startActivity(i);
    } else {
      Toast.makeText(this, "Make sure you have installed " + hint, Toast.LENGTH_SHORT).show();
    }
  }
}