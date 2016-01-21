package means.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.server.SimpleServerFactory;

public class MeansConfiguration extends Configuration implements AssetsBundleConfiguration{
	@Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    @Override
    public AssetsConfiguration getAssetsConfiguration() 
    {
      return assets;
    }
    
    /**
     * Constructs a new edSystemConfiguration.
     */
    public MeansConfiguration() {
        setServerFactory(new SimpleServerFactory());
    }
    
    /**
     * Container for the database configuration.
     */
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();
    

    /**
     * Return the container with the database information
     */
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
    
}