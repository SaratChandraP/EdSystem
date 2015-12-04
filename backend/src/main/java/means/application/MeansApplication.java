package means.application;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import means.configuration.MeansConfiguration;
import means.solution.TestResource;
import means.solution.TestsResource;
import means.trials.TryHashmap;
import means.trials.database;


public class MeansApplication extends Application<MeansConfiguration>
{

    @Override
    public void run(MeansConfiguration configuration, Environment environment)
    {
        environment.jersey().register(new TestsResource());
    }
    
    @Override
    public void initialize(Bootstrap<MeansConfiguration> bootstrap)
    {
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }
    


    public static void main(String[] args) throws Exception
    {
    	new MeansApplication().run(args);
//    	Object somename = database.connect();
//    	System.out.println(somename);
    	//Object testnew = TryHashmap.tryHash();
    	//System.out.println(testnew);
    }
    
}