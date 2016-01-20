package means.application;

import org.skife.jdbi.v2.DBI;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import means.config.MeansConfiguration;
import means.db.QuestionsDao;
import means.resources.TestsByCategory;
import means.resources.TestsResource;

public class MeansApplication extends Application<MeansConfiguration>
{
    @Override
    public void run(MeansConfiguration configuration, Environment environment) throws ClassNotFoundException
    {
        /*
         * JDBI
         */
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        
        /*
         * DAOs
         */
        final QuestionsDao qDao= jdbi.onDemand(QuestionsDao.class);
        
        /*
         * Add Resources
         */
        environment.jersey().register(new TestsResource());
        environment.jersey().register(new TestsByCategory());
        
        /*
         * Add Providers
         */
        
        
        /*
         * Add Health Checks
         */
        
        
        /*
         * Filters
         */
        
    }
    
    @Override
    public void initialize(Bootstrap<MeansConfiguration> bootstrap)
    {
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }
    
    public static void main(String[] args) throws Exception
    {
    	new MeansApplication().run(args);
    }
    
}