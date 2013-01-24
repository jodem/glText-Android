// This is based on the OpenGL ES 1.0 sample application from the Android Developer website:
// http://developer.android.com/resources/tutorials/opengl/opengl-es10.html

package com.android.texample;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Texample extends Activity
{
   private GLSurfaceView glView;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate( savedInstanceState );

      // Create a GLSurfaceView instance and set it
      // as the ContentView for this Activity.
      glView = new TexampleSurfaceView( this );
      setContentView( glView );
   }

   @Override
   protected void onPause() {
      super.onPause();
      // The following call pauses the rendering thread.
      // If your OpenGL application is memory intensive,
      // you should consider de-allocating objects that
      // consume significant memory here.
      glView.onPause();
   }

   @Override
   protected void onResume() {
      super.onResume();
      // The following call resumes a paused rendering thread.
      // If you de-allocated graphic objects for onPause()
      // this is a good place to re-allocate them.
      glView.onResume();
   }
}

class TexampleSurfaceView extends GLSurfaceView {

   public TexampleSurfaceView(Context context){
      super( context );

      // Set the Renderer for drawing on the GLSurfaceView
      setRenderer( new TexampleRenderer( context ) );
   }
}
