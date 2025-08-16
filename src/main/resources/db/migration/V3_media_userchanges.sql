DROP TABLE IF EXISTS media_entity;

CREATE TABLE recommendation_list (
    id BIGSERIAL PRIMARY KEY,
    owner_id BIGINT NOT NULL,
    name VARCHAR(255),
    visibility VARCHAR(50),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT fk_recommendation_list_owner FOREIGN KEY (owner_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE media_item (
    id BIGSERIAL PRIMARY KEY,
    recommendation_list_id BIGINT NOT NULL,
    external_id VARCHAR(255) NOT NULL,
    source VARCHAR(50),
    CONSTRAINT fk_media_item_recommendation_list FOREIGN KEY (recommendation_list_id)
        REFERENCES recommendation_list(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_media_item_external_id ON media_item(external_id);
CREATE INDEX idx_media_item_recommendation_list_id ON media_item(recommendation_list_id);
CREATE INDEX idx_recommendation_list_owner_id ON recommendation_list(owner_id);